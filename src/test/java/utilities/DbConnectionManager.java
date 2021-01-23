package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionManager {
//Single connection for all db Queries 
    private static DbConnectionManager dbInstance = null;
    private Connection con;

    private DbConnectionManager(String url) {
        try {
            Class.forName(ConfigReader.readProjectConfig("QaDbDriver"));
            this.con = DriverManager.getConnection(url);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.con;
    }

    public static DbConnectionManager getDbInstance(String url) throws SQLException {
        if (dbInstance == null) {
            dbInstance = new DbConnectionManager(url);
        } else if (dbInstance.getConnection().isClosed()) {
            dbInstance = new DbConnectionManager(url);
        }
        return dbInstance;
    }

}
