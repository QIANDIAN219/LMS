import java.lang.reflect.Array;
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
    private Date borrowDate;

    Record(){

    }
    Record(String bookID, String readerID, Date borrowDate){
        this.bookID = bookID;
        this.readerID = readerID;
        this.borrowDate = borrowDate;
    }
    Record(ResultSet rs){
        try {
            this.bookID = rs.getString("bookID");
            this.readerID = rs.getString("readerID");
            this.borrowDate = rs.getDate("borrowDate");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void savaRecord(){
        String str = "表名";
        String sql = "INSERT INTO ? VALUES(?, ?, ?, ?)";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setInt(2, (int) Math.random()*1000);
                pstmt.setString(3, this.bookID);
                pstmt.setString(4, this.readerID);
                pstmt.setDate(5, (java.sql.Date) this.borrowDate);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    private void deleteRecord(){
        String str = "表名";
        String sql = "DELETE FROM ? WHERE bookid=? AND readid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, this.bookID);
                pstmt.setString(3, this.readerID);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }
    /*
    private static Record getRecord(String bookID){
        Record record = null;
        String str = "表名";
        String sql = "SELECT * FROM ? WHERE bookid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, bookID);
                pstmt.execute();
                ResultSet rs = pstmt.getResultSet();
                rs.next();
                record = new Record(rs);
                return record;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
        return record;
    }

     */

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
        Date now = new Date();
        boolean flag = false;
        return flag;
    }

    public static void borrowBook(Book book, Reader reader){
        Date date = new Date();
        Record record = new Record(book.getBookId(), reader.getReaderID(), date);
        record.savaRecord();
    }

    public static void returnBook(Book book){
        Record record = new Record(book.getBookId(), null, null);
        if(!isExpired(record)){
            record.deleteRecord();
        }
    }
}
