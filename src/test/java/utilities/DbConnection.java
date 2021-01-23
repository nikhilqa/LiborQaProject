package utilities;

import java.sql.*;

public class DbConnection {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public void connect(String dbname, String user, String password) {
        String connectionString = "jdbc:mysql://localhost/" + dbname + "?user=" + user + "&password=" + password;
        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public ResultSet executeSelect(String query) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;
    }
}
