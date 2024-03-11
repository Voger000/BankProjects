package Bank;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;
public class DataBase {

    public static void ConnectionToDatabase() {
        String url = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user name from DataBase: ");
        String username = scanner.nextLine();
        System.out.println("Enter the password from user DataBase: ");
        String password = scanner.nextLine();
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            url = property.getProperty("db.host");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        Connection connection = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null) {
                System.out.println("Підключення до бази даних MySQL успішне!");
            }
        } catch (SQLException ex) {
            System.out.println("Помилка підключення до бази даних MySQL: " + ex.getMessage());
        }
    }
}