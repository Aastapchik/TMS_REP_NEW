package teachmyskill.task.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Connect {

    public static Connection getConnect() {

        Driver driver = new org.postgresql.Driver();
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String URL = "jdbc:postgresql://localhost:5432/Employees";
        String LOGIN = "postgres";
        String PASSWORD = "admin";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
