package org.example;
import Bank.AccountUsersOfBank;
import Bank.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        AccountUsersOfBank accountUssersOfBank = new AccountUsersOfBank();
        MainMenu.mainmenu(args);
    }
}

