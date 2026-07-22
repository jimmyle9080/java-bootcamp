package com.academy.bank;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private String type;          // "Deposit" or "Withdraw"
    private double amount;
    private String date;

    public Transaction(String transactionId, String accountNumber,
                       String type, double amount, String date) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() { return transactionId; }
    public String getAccountNumber() { return accountNumber; }
    public String getType()          { return type; }
    public double getAmount()        { return amount; }
    public String getDate()          { return date; }

    public void display() {
        System.out.printf("Txn %s | %s | %s | %.2f | %s%n",
                transactionId, accountNumber, type, amount, date);
    }
}