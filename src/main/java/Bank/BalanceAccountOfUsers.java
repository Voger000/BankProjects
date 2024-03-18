package Bank;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceAccountOfUsers {
    private static Connection connection;

    DataBase dataBase = new DataBase();

    public static void BalanceOfAccount(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT balance FROM usersOfBank WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("The balance of " + username + " is: " + resultSet.getDouble("balance"));
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}