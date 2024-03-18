package Bank;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
public class DataBase {

    public static Connection ConnectionToDatabase() {
        String url = null;
        String username = null;
        String password = null;
        FileInputStream fis = null;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            url = property.getProperty("db.host");
            username = property.getProperty("db.login");
            password = property.getProperty("db.password");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connection to database is successful!");
            } else {
                System.out.println("Failed to establish connection to database.");
            }
        } catch (SQLException ex) {
            System.out.println("Error while connection to database: " + ex.getMessage());
        }
        return connection;
    }
}