package com.hexaware.dto;

public class BankAccount {
    private long accountNumber;
    private String holderName;
    private String type;
    private double balance;
    private static long generatedAccountNumber = 1;

    public BankAccount() {
        super();
    }

    public BankAccount(String holderName, String type, double balance) {
        this.accountNumber = generatedAccountNumber++;
        this.holderName = holderName;
        this.type = type;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount [accountNumber=" + accountNumber + ", holderName=" + holderName + ", type=" + type
                + ", balance=" + balance + "]";
    }
}
