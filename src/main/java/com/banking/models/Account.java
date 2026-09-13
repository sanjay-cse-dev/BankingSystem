package com.banking.models;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private int pin;
    private double balance;
    private boolean isActive;

    // Constructor
    public Account(String accountNumber, String accountHolderName, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = initialBalance;
        this.isActive = true;
    }

    // Getters

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getPin(){
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setters
    public void setPin(int newpin) {
        this.pin = newpin;
    }

    public void setActive(boolean active) {
        this.isActive = active;
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