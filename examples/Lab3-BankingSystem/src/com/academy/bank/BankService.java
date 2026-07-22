package com.academy.bank;

import java.util.Scanner;

public class BankService {
    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;
    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }

    // ---------- lookups ----------
    private Customer findCustomer(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equals(id)) {
                return customers[i];
            }
        }
        return null;
    }

    private Account findAccount(String number) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(number)) {
                return accounts[i];
            }
        }
        return null;
    }

    // ---------- create ----------
    public void createCustomer() {
        System.out.print("Customer ID : ");
        String id = scanner.nextLine();
        if (findCustomer(id) != null) {
            System.out.println("Customer already exists.");
            return;
        }
        System.out.print("Name : ");
        String name = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Phone : ");
        String phone = scanner.nextLine();

        customers[customerCount++] = new Customer(id, name, email, phone);
        System.out.println("Customer Created Successfully.");
    }

    public void createSavingsAccount() {
        System.out.print("Customer ID : ");
        Customer c = findCustomer(scanner.nextLine());
        if (c == null) { System.out.println("Customer not found."); return; }

        double balance = readPositiveAmount("Initial Balance : ");
        System.out.print("Interest Rate (%) : ");
        double rate = Double.parseDouble(scanner.nextLine());

        String number = String.valueOf(nextAccountNumber++);
        accounts[accountCount++] = new SavingsAccount(number, balance, c, rate);

        System.out.println("Savings Account Created.");
        System.out.println("Account Number : " + number);
        System.out.println("Balance : " + balance);
        System.out.println("Interest Rate : " + rate + "%");
    }

    public void createCurrentAccount() {
        System.out.print("Customer ID : ");
        Customer c = findCustomer(scanner.nextLine());
        if (c == null) { System.out.println("Customer not found."); return; }

        double balance = readPositiveAmount("Initial Balance : ");
        System.out.print("Transaction Fee : ");
        double fee = Double.parseDouble(scanner.nextLine());

        String number = String.valueOf(nextAccountNumber++);
        accounts[accountCount++] = new CurrentAccount(number, balance, c, fee);

        System.out.println("Current Account Created.");
        System.out.println("Account Number : " + number);
        System.out.println("Balance : " + balance);
    }

    // ---------- money movement ----------
    public void deposit() {
        System.out.print("Account Number : ");
        Account a = findAccount(scanner.nextLine());
        if (a == null) { System.out.println("Account not found."); return; }

        double amount = readPositiveAmount("Deposit Amount : ");
        a.deposit(amount);
        recordTransaction(a, "Deposit", amount);
        System.out.println("Balance Updated : " + a.getBalance());
    }

    public void withdraw() {
        System.out.print("Account Number : ");
        Account a = findAccount(scanner.nextLine());
        if (a == null) { System.out.println("Account not found."); return; }

        double amount = readPositiveAmount("Withdraw : ");
        if (a.withdraw(amount)) {
            recordTransaction(a, "Withdraw", amount);
            System.out.println("Balance Updated : " + a.getBalance());
        }
    }

    // ---------- display ----------
    public void displayAccounts() {
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccount();
            System.out.println("----------------------------------");
        }
    }

    public void displayCustomers() {
        for (int i = 0; i < customerCount; i++) {
            customers[i].printDetails();
            System.out.println("----------------------------------");
        }
    }

    // ---------- helpers ----------
    private double readPositiveAmount(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine());
    }

    private void recordTransaction(Account a, String type, double amount) {
        String id = String.valueOf(nextTransactionNumber++);
        transactions[transactionCount++] =
                new Transaction(id, a.getAccountNumber(), type, amount, "today");
    }
}