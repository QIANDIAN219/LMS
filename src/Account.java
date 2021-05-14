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
    Account(ResultSet rs){
        try {
            this.username = rs.getString("username");
            this.password = rs.getString("password");
            this.type = rs.getString("type");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void savaAccount(Account account){
        String str = "表名";
        String sql = "INSERT INTO ? VALUES(?, ?, ?)";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, account.username);
                pstmt.setString(3, account.password);
                pstmt.setString(4, account.type);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public void deleteAccount(Account account){
        String str = "表名";
        String sql = "DELETE FROM ? WHERE username=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, account.username);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public static void updateAccount(Account newAccount){
        String str = "表名";
        String sql = "UPDATE ? SET password=?, type=? WHERE username=?";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        if(connection != null){
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, str);
                pstmt.setString(2, newAccount.password);
                pstmt.setString(3, newAccount.type);
                pstmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
        }
    }

    public boolean isAccount(){
        boolean flag = false;
        return flag;
    }

    public static List<Account> getAccounts(){
        List<Account> list = new ArrayList<>();
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
                    list.add(new Account(rs));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("连接失败");
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
