package Bank;
import java.sql.*;
import java.util.Scanner;
import java.util.Random;
import Bank.DataBase;
public class AccountUsersOfBank {
    public static void checkingInformation () {
        DataBase dataBase = new DataBase();
        Connection conn = dataBase.ConnectionToDatabase();

        Scanner singin = new Scanner(System.in);
        System.out.println("Enter the first name:");
        String firstName = singin.nextLine();
        System.out.println("Enter the last name:");
        String lastName = singin.nextLine();

        String query = "SELECT * FROM schemat_info.users WHERE first_name = ? AND second_name = ?";

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            if (pstmt != null) {
                rs = pstmt.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.printf("%-10s %-15s %-15s %-5s %-10s %-25s\n", "User ID", "First Name", "Last Name", "Age", "Balance", "Number users bunk");
        try {
            if (rs != null) {
                while (rs.next()) {
                    System.out.printf("%-10d %-15s %-15s %-5s %-10s %-25s\n",
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("second_name"),
                            rs.getString("age"),
                            rs.getString("balance"),
                            rs.getString("number_of_bank_account"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createAccount() {
        DataBase dataBase = new DataBase();
        Connection conn = DataBase.ConnectionToDatabase();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter the age:");
        String ageString = scanner.nextLine();
        int age = Integer.parseInt(ageString);
        System.out.println("Enter the balance:");
        double balance = scanner.nextDouble();
        System.out.println("Enter the number of bank account:");
        long number_of_bank_account = scanner.nextLong();

        String query = "INSERT INTO schemat_info.users (first_name, second_name, age, balance, number_of_bank_account) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, age);
            pstmt.setDouble(4, balance);
            pstmt.setLong(5, number_of_bank_account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}