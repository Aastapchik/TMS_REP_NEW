package org.task.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static Connect instance;
    private static final String dbDriver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/Employees";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    private Connect() {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading database driver");
        }
    }

    public static Connect getInstance() {
        if (instance == null) {
            synchronized (Connect.class) {
                if (instance == null) {
                    instance = new Connect();
                }
            }
        }
        return instance;
    }

    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}