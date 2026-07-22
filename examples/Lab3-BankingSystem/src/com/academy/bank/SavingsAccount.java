package com.academy.bank;

public class SavingsAccount extends Account implements Printable {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance,
                          Customer customer, double interestRate) {
        super(accountNumber, balance, customer);   // parent sets number/balance/customer
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100.0;   // uses getter — balance is private in parent
    }

    @Override
    public void displayAccount() {
        System.out.println("Savings Account");
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Customer : " + getCustomer().getName());
        System.out.println("Balance : " + getBalance());
        System.out.println("Interest Rate : " + interestRate + "%");
        System.out.println("Interest : " + calculateInterest());
    }

    @Override
    public void printDetails() { displayAccount(); }

    @Override
    public String getAccountType() { return "Savings"; }
}