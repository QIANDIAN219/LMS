import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String readerID;
    private String readerName;
    private String address;
    private String phone;
    private String email;

    Reader(){

    }

    Reader(String readerID, String readerName, String address, String phone, String email) {
        this.readerID = readerID;
        this.readerName = readerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    Reader(ResultSet rs) {
        try {
            this.readerID = rs.getString("readerid");
            this.readerName = rs.getString("readerName");
            this.address = rs.getString("address");
            this.phone = rs.getString("phone");
            this.email = rs.getString("email");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void savaReader(Reader reader){
        String str = "表名";
        String sql = "INSERT INTO ? VALUES(?, ?, ?, ?, ?, ?)";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setInt(2, (int) Math.random()*1000);
                pstmt.setString(3, reader.readerID);
                pstmt.setString(4, reader.readerName);
                pstmt.setString(5, reader.address);
                pstmt.setString(6, reader.phone);
                pstmt.setString(7, reader.email);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public static void deleteReader(Reader reader){
        String str = "表名";
        String sql = "DELETE FROM ? WHERE rederid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, reader.readerID);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public static void updateReader(Reader newReader){
        String str = "表名";
        String sql = "UPDATE ? SET readername=?, address=?, phone=?, email=? WHERE readerid=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, newReader.readerName);
                pstmt.setString(3, newReader.address);
                pstmt.setString(4, newReader.phone);
                pstmt.setString(5, newReader.email);
                pstmt.setString(6, newReader.readerID);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public static Reader getReader(String readerID){
        Reader reader = null;
        return reader;
    }

    public static List<Reader> getReaders(){
        List<Reader> list = new ArrayList<>();
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
                while (rs.next()){
                    list.add(new Reader(rs));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
        return list;
    }



    public String getReaderID() {
        return readerID;
    }

    public void setReaderID(String readerID) {
        this.readerID = readerID;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
