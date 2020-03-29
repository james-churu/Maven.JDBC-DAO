package daos;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import sun.rmi.runtime.Log;

import java.sql.*;


public class ConnectionClass {

    public static final String URL = "jdbc:mysql://localhost:3306/randomDB?serverTimezone=UTC";
    public static final String USER = "labs";
    public static final String PASS = "labs";

    public Connection connection;

    public Connection getConnection() {

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection Successful");

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        return connection;
    }
}
