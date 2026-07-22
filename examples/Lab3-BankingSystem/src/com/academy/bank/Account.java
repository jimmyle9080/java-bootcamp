package com.academy.bank;

public abstract class Account {
    private String accountNumber;
    private double balance;
    private Customer customer;

    protected Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance()       { return balance; }
    public Customer getCustomer()    { return customer; }

    protected void setBalance(double balance) {   // protected: only this class + subclasses
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive.");
            return;
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        double total = amount + calculateCharges();   // fee hook — 0 unless overridden
        if (amount <= 0 || total > balance) {
            System.out.println("Withdrawal rejected.");
            return false;
        }
        balance -= total;
        return true;
    }

    public abstract void displayAccount();            // each type MUST define this

    // default hooks — subclasses override the ones they need
    public double calculateCharges()  { return 0.0; }
    public double calculateInterest() { return 0.0; }
    public String getAccountType()    { return "Account"; }
}