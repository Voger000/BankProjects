package Bank;
import Bank.AccountUsersOfBank;
import Bank.BalanceAccountOfUsers;
import Bank.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBase {

    public static void ConnectionToDatabase(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "Qwertyuiop123QWE@";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null) {
                System.out.println("Підключення до бази даних MySQL успішне!");
            }
        } catch (SQLException ex) {
            System.out.println("Помилка підключення до бази даних MySQL: " + ex.getMessage());
        }
    }
}