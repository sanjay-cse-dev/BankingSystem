package com.banking.models;

import com.banking.exception.InvalidAmountException;
import com.banking.exception.InvalidPinException;

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
        throw new InvalidPinException("Invalid PIN.");
    }

    // Setters
    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public boolean withdraw(double amount){
        if(amount <= 0) {
            throw new InvalidAmountException("Withdraw amount must be greater than zero");
        }
        if(amount > balance){
            throw new InvalidAmountException("Insufficient balance!");
        }
        if(amount > 1_00_000){
            throw new InvalidAmountException("You cannot withdraw amount more than ₹1,00,000 at once!");
        }
        this.balance -= amount;
        return true;
    }

    public boolean deposit(double amount){
        if(amount <= 0){
            throw new InvalidAmountException("Deposit amount must be greater than zero");
        }
        balance += amount;
        return true;
    }

}