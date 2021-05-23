package Class;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Record {
    private String recordID;
    private String bookID;
    private String readerID;

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    private Date borrowDate;

    public Record(){

    }
    Record(String bookID, String readerID){
        this.bookID = bookID;
        this.readerID = readerID;
    }
    public Record(ResultSet rs){
        try {
            this.bookID = rs.getString("bookID");
            this.readerID = rs.getString("readerID");
            this.borrowDate = rs.getDate("borrowDate");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void savaRecord() throws SQLException {
        String sql1 = "INSERT INTO RECORD VALUES(?, ?, ?, ?)";
        String sql2 = "UPDATE BOOK SET status='0' WHERE bookid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        pstmt = connection.prepareStatement(sql1);
        pstmt.setString(1, String.valueOf((int)(Math.random()*10000)));
        pstmt.setString(2, this.bookID);
        pstmt.setString(3, this.readerID);
        pstmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
        pstmt.executeUpdate();
        pstmt = connection.prepareStatement(sql2);
        pstmt.setString(1, this.bookID);
        pstmt.executeUpdate();
        connection.close();
        pstmt.close();
    }

    private int deleteRecord() throws SQLException {
        String sql1 = "DELETE FROM RECORD WHERE bookid=?";
        String sql2 = "UPDATE BOOK SET status='1' WHERE bookid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        pstmt = connection.prepareStatement(sql1);
        pstmt.setString(1, this.bookID);
        int num = pstmt.executeUpdate();
        pstmt = connection.prepareStatement(sql2);
        pstmt.setString(1, this.bookID);
        pstmt.executeUpdate();
        connection.close();
        pstmt.close();
        return num;
    }

    public static List<Record> getRecords(){
        List<Record> list = new ArrayList<>();
        String sql = "SELECT * FROM RECORD";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while(rs.next()){
                list.add(new Record(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    private static boolean isExpired(Record record){
        boolean flag = false;
        return flag;
    }

    public static void borrowBook(Book book, Reader reader){
        String sql = "SELECT * FROM BOOK WHERE bookid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, book.getBookId());
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            rs.next();
            Book book1 = new Book(rs);
            if(book1.getStatus().equals("1")){
                Record record = new Record(book.getBookId(), reader.getReaderID());
                record.savaRecord();
                JOptionPane.showMessageDialog(null, "借书成功", "借书", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "该图书不存在或不在库中", "错误", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "该图书不存在或不在库中", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void returnBook(Book book){
        String sql = "SELECT * FROM RECORD WHERE bookid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, book.getBookId());
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            rs.next();
            if(rs != null){
                Record record = new Record(book.getBookId(), null);
                if(record.deleteRecord() > 0){
                    JOptionPane.showMessageDialog(null, "还书成功", "还书", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "图书编号错误或没有借阅该图书", "错误", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "图书编号错误或没有借阅该图书", "错误", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
