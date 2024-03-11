package org.example;
import Bank.AccountUsersOfBank;
import Bank.BalanceAccountOfUsers;
import Bank.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        dataBase.ConnectionToDatabase();
        AccountUsersOfBank accountUssersOfBank = new AccountUsersOfBank();
    }
}