package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://root:ENigzLfZbMgcOEaTfErJlJsiGGPxQeaN@autorack.proxy.rlwy.net:36388/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "ENigzLfZbMgcOEaTfErJlJsiGGPxQeaN";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
