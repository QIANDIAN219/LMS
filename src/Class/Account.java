package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String username;
    private String password;
    private String type;

    Account(){

    }
    public Account(ResultSet rs) throws SQLException {
        this.username = rs.getString("username");
        this.password = rs.getString("password");
        this.type = rs.getString("type");
    }


    public void savaAccount(){
        String sql = "INSERT INTO Account VALUES(?, ?, ?, ?)";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, (int) Math.random()*1000);
            pstmt.setString(2, this.username);
            pstmt.setString(3, this.password);
            pstmt.setString(4, this.type);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAccount(){
        String sql = "DELETE FROM Account WHERE username=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, this.username);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAccount(){
        String sql = "UPDATE Account SET password=?, type=? WHERE username=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, this.password);
            pstmt.setString(2, this.type);
            pstmt.setString(3, this.username);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean isAccount(){
        boolean flag = false;
        return flag;
    }

    public static List<Account> getAccounts(){
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while(rs.next()){
                list.add(new Account(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
