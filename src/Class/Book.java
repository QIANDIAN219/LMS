package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private String publisher;
    private double price;
    private String abstracts;
    private String catelog;
    private String status;

    public Book(){
    }

    Book(ResultSet rs) {
        try {
            this.bookId = rs.getString("bookid");
            this.bookName = rs.getString("bookname");
            this.author = rs.getString("author");
            this.publisher = rs.getString("publisher");
            this.price = rs.getDouble("price");
            this.abstracts = rs.getString("abstracts");
            this.catelog = rs.getString("catelog");
            this.status = rs.getString("status");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Book(String bookId){
        this.bookId = bookId;
        this.bookName = null;
        this.author = null;
        this.publisher = null;
        this.price = 0;
        this.abstracts = null;
        this.catelog = null;
        this.status = null;
    }

    public Book(String bookId, String bookName, String author, String publisher, double price, String abstracts, String catelog, String status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.abstracts = abstracts;
        this.catelog = catelog;
        this.status = status;
    }


    public void savaBook(){
        String str = "表名";
        String sql = "INSERT INTO ? VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setInt(2, (int) Math.random()*1000);
                pstmt.setString(3, this.bookId);
                pstmt.setString(4, this.bookName);
                pstmt.setString(5, this.author);
                pstmt.setString(6, this.publisher);
                pstmt.setDouble(7, this.price);
                pstmt.setString(8, this.abstracts);
                pstmt.setString(9, this.status);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public void deleteBook(){
        String str = "表名";
        String sql = "DELETE FROM ? WHERE bookid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, this.bookId);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public void updateBook(){
        String str = "表名";
        String sql = "UPDATE ? SET bookName=?, author=?, publisher=?, price=?, abstracts=?, catelog=?, status=? WHERE bookid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, this.bookName);
                pstmt.setString(3, this.author);
                pstmt.setString(4, this.publisher);
                pstmt.setDouble(5, this.price);
                pstmt.setString(6, this.abstracts);
                pstmt.setString(7, this.catelog);
                pstmt.setString(8, this.status);
                pstmt.setString(8, this.bookId);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public static List<Book> getBooks(Book bookCondition){
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE";
        String[] str = new String[6];
        int k = 0;
        if(bookCondition.bookId != null){
            sql = sql.concat("bookid=? AND");
            str[k++] = "bookid";
        }
        if(bookCondition.bookName != null){
            sql = sql.concat("bookname=? AND");
            str[k++] = "bookname";
        }
        if(bookCondition.author != null){
            sql = sql.concat("author=? AND");
            str[k++] = "author";
        }
        if(bookCondition.publisher != null){
            sql = sql.concat("publisher=? AND");
            str[k++] = "publisher";
        }
        if(bookCondition.abstracts != null){
            sql = sql.concat("abstracts=? AND");
            str[k++] = "abstracts";
        }
        if(bookCondition.catelog != null){
            sql = sql.concat("catelog=?");
            str[k++] = "catelog";
        }
        if(sql.endsWith(" AND")){
            sql = sql.substring(0, sql.lastIndexOf(" AND"));
            System.out.println(sql);
        }

        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                for(int i = 0; i < str.length; i++){
                    if(str[i] != null){
                        pstmt.setString(i+1, str[i]);
                    }
                }
                pstmt.execute();
                ResultSet rs = pstmt.getResultSet();
                while (rs.next()){
                    list.add(new Book(rs));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
        return list;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getCatelog() {
        return catelog;
    }

    public void setCatelog(String catelog) {
        this.catelog = catelog;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
