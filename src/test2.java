import Class.JDBC;

import Class.*;

import java.sql.*;

public class test2 {
    public static void main(String[] args) {
        String sql = "SELECT * FROM RECORD WHERE BOOKID='0003'";
        Connection connection = JDBC.LinkConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            rs.next();
            Record record = new Record(rs);
            System.out.println(record.getBorrowDate());

            Date end  = (Date) record.getBorrowDate();
            Date te = new Date(record.getBorrowDate().getTime());
            System.out.println(te);
            System.out.println(end);
            System.out.println(new java.util.Date().getTime());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
