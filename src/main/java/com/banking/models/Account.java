package com.banking.models;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private int pin;
    private double balance;

    // Constructor
    public Account(String accountNumber, String accountHolderName, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = initialBalance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyPin(int pin){
        return this.pin == pin;
    }

    // Setters
    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public boolean withdraw(double amount){
        if(amount > balance) return false;

        this.balance -= amount;
        return true;
    }

    public boolean deposit(double amount){
        if(amount <= 0){
            return false;
        }
        balance += amount;
        return true;
    }

}