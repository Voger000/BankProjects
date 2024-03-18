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
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Check the information of the user , entre Check for show information");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if (option.equals("Check")) {
            AccountUsersOfBank.checkingInformation();
        }


    }
}
