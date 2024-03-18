package org.example;
import Bank.AccountUsersOfBank;
import java.util.Scanner;
import Bank.DataBase;
public class MainMenu {
    public static void mainmenu(String[] args) {
        DataBase dataBase;
        dataBase = new DataBase();
        DataBase.ConnectionToDatabase();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Welcome to the bank application!");
        while (true) {
            System.out.println("Please choose one of the following options:");
            System.out.println("1. Sing in, entre SingIn for sing in");
            System.out.println("2. Sing up, entre SingUp for sing up");
            System.out.println("2. Exit the application, entre Exit for exit");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if (option.equals("SingIn") || option.equals("1")) {
                System.out.println("Enter the Firs Name and Last Name to sing in");
                AccountUsersOfBank.checkingInformation();
            }
            if (option.equals("SingUp") || option.equals("2")) {
                System.out.println("Enter the Firs Name and Last Name to sing up");
                AccountUsersOfBank.createAccount();

            }
        }

    }
}