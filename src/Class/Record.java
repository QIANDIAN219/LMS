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

    }

    private void deleteRecord() throws SQLException {
        String sql = "DELETE FROM RECORD WHERE bookid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, this.bookID);
        pstmt.executeUpdate();
    }

    public static List<Record> getRecords(){
        List<Record> list = new ArrayList<>();
        String str = "表名";
        String sql = "SELECT * FROM ?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.execute();
                ResultSet rs = pstmt.getResultSet();
                while(rs.next()){
                    list.add(new Record(rs));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
        return list;
    }

    private static boolean isExpired(Record record){
        boolean flag = false;
        return flag;
    }

    public static void borrowBook(Book book, Reader reader){
        Record record = new Record(book.getBookId(), reader.getReaderID());
        try {
            record.savaRecord();
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "网络连接超时", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void returnBook(Book book){
        Record record = new Record(book.getBookId(), null);
        try {
            record.deleteRecord();
            JOptionPane.showMessageDialog(null, "还书成功", "还书", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "网络连接超时", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
