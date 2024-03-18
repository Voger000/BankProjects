package Bank;
import java.sql.*;
import java.util.Scanner;
import java.util.Random;
import Bank.DataBase;
public class AccountUsersOfBank {
    public static void checkingInformation () {
        DataBase dataBase = new DataBase();
        Connection conn = dataBase.ConnectionToDatabase();


        // Ask the user to enter the first name and last name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name:");
        String lastName = scanner.nextLine();

        // Create the SQL query
        String query = "SELECT * FROM schemat_info.users WHERE first_name = ? AND second_name = ?";

        // Create a PreparedStatement object
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Execute the SQL query and get the result in a ResultSet
        ResultSet rs = null;
        try {
            if (pstmt != null) {
                rs = pstmt.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Print the table header
        System.out.printf("%-10s %-15s %-15s %-5s %-10s %-25s\n", "User ID", "First Name", "Last Name", "Age", "Balance", "Number users bunk");

        // Iterate through the ResultSet and print the data
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

    }
}