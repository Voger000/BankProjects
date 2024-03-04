package Bank;
import java.sql.*;
import java.util.Scanner;
import org.example.Main;
public class DataBase {
    public void ConnectionToDataBase(String[] args){
        String url = "jdbc:mysql://localhost:3306/DataBaseOfBank";
        String username = "username";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть ім'я користувача: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Введіть пароль: ");
            String inputPassword = scanner.nextLine();

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, inputUsername);
            statement.setString(2, inputPassword);
            ResultSet resultSet = statement.executeQuery();
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Запис успішно додано!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
