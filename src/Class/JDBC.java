package Class;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static Connection LinkConnection(){
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
            connection = DriverManager.getConnection(url, "lzh", "lzh1234");
            return connection;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "网络连接超时", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "网络连接超时", "错误", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
}
