package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: connection
 * Project Name: JavaPracticalExam
 * Date: 18-03-2021
 */

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Practical";
    private static final String userName = "root";
    private static final String password = "";

    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    public void connectToDatabase(){
        try {
            connection = DriverManager.getConnection(URL, userName,password);
            System.out.println("Database Connected Successfully.");
        } catch (SQLException e) {
            System.err.println("Could not connect to database.");
        }
    }
}
