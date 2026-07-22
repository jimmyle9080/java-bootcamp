package com.academy.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // the ONE scanner
        BankService bank = new BankService(scanner); // pass it in

        boolean running = true;
        while (running) {
            System.out.println("================================");
            System.out.println("Bank Management System");
            System.out.println("================================");
            System.out.println("1 Create Customer");
            System.out.println("2 Create Savings Account");
            System.out.println("3 Create Current Account");
            System.out.println("4 Deposit");
            System.out.println("5 Withdraw");
            System.out.println("6 Display Accounts");
            System.out.println("7 Display Customers");
            System.out.println("8 Exit");
            System.out.print("Choice : ");

            String choice = scanner.nextLine();      // read as line, then match

            switch (choice) {
                case "1": bank.createCustomer();        break;
                case "2": bank.createSavingsAccount();  break;
                case "3": bank.createCurrentAccount();  break;
                case "4": bank.deposit();               break;
                case "5": bank.withdraw();              break;
                case "6": bank.displayAccounts();       break;
                case "7": bank.displayCustomers();      break;
                case "8":
                    System.out.println("Thank You");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();                             // close once, at the end
    }
}