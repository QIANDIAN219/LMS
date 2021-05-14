import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String sql = "SELECT * FROM ? WHERE";
        Book bookCondition = new Book("001", "三体", "刘慈欣", "北京大学出版社", 40.0, null, "科幻", "借出");
        String[] str = new String[6];
        int k = 0;
        if(bookCondition.getBookId() != null) {
            sql = sql.concat(" bookid=? AND");
            str[k++] = "bookid";
        }
        if(bookCondition.getBookName() != null) {
            sql = sql.concat(" bookname=? AND");
            str[k++] = "bookname";
        }
        if(bookCondition.getAuthor() != null) {
            sql = sql.concat(" author=? AND");
            str[k++] = "author";
        }
        if(bookCondition.getPublisher() != null) {
            sql = sql.concat(" publisher=? AND");
            str[k++] = "publisher";
        }
        if(bookCondition.getAbstracts() != null) {
            sql = sql.concat(" abstracts=? AND");
            str[k++] = "abstracts";
        }
        if(bookCondition.getCatelog() != null){
            sql = sql.concat(" catelog=?");
            str[k++] = "catelog";
        }
        if(sql.endsWith(" AND")){
            sql = sql.substring(0, sql.lastIndexOf(" AND"));
            System.out.println(sql);
        }else{
            System.out.println(sql);
        }
        float a = 2, b = 3, h = 4;
        System.out.println((1/2)*(a+b)*h);
        System.out.println((a + b) * h / 2);
        System.out.println((a + b) * h * 1 / 2);
        System.out.println(h / 2 * (a + b));
        System.out.println(a-- + " " + b++);
    }
}
