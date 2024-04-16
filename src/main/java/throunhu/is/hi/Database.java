package throunhu.is.hi;
import org.example.softdev_4t.RunApp;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    public Connection getConnection() throws URISyntaxException {
        URL res = RunApp.class.getResource("DayTours.db");
        if (res == null) {
            throw new RuntimeException("Database file not found");
        }
        String url = "jdbc:sqlite:" + new File(res.toURI()).getPath();
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
            throw new RuntimeException("Cannot connect to the database", e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        }
        catch(SQLException e) {
            System.err.println(e);
        }
    }

}


