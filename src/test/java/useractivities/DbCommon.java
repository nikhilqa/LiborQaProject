package useractivities;

import utilities.ConfigReader;
import utilities.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DbCommon {

    DbConnection liborDb = new DbConnection();
    ResultSet rs;

    public void connectToDb(String dbname) {
        liborDb.connect(ConfigReader.readProjectConfig("DbName"), ConfigReader.readProjectConfig("Username"), ConfigReader.readProjectConfig("password"));
    }

    public void checkQuery(String query) {
        rs = liborDb.executeSelect(query);
    }

    public void countNumerOfRows(int resultsize) {
        //Get size of resultset
        int size = 0;
        try {
            rs.last();
            size = rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(resultsize, size);
    }

/*    public void checkAllResults(String col1, String col2, String col3, String col4, String col5, String col6) {
        try {
            assertEquals(col1, rs.getString(""));
            assertEquals(col2, rs.getString(""));
            assertEquals(col3, rs.getString(""));
            assertEquals(col4, rs.getString(""));
            assertEquals(col5, rs.getString(""));
            assertEquals(col6, rs.getString(""));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
}

