package org.example;
import Bank.AccountUsersOfBank;
import Bank.BalanceAccountOfUsers;
import Bank.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        // Параметри підключення до бази даних MySQL
        String url = "jdbc:mysql://localhost:3306/MySQL"; // URL для з'єднання з базою даних
        String username = "root"; // Ім'я користувача для підключення
        String password = "Qwertyuiop123QWE@"; // Пароль для підключення

        // Створення об'єкту Connection для з'єднання з базою даних
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null) {
                System.out.println("Підключення до бази даних MySQL успішне!");
            }
        } catch (SQLException ex) {
            System.out.println("Помилка підключення до бази даних MySQL: " + ex.getMessage());
        }
    }
}