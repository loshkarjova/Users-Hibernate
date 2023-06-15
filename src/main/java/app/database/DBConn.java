package app.database;

import app.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    public static Connection connection(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(Constants.DB_JDBC + Constants.DB_NAME,
                    Constants.DB_USER, Constants.DB_PASS);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }return conn;
    }
}
