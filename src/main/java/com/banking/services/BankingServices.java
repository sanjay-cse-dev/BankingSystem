package com.banking.services;

import com.banking.models.Account;

public interface BankingServices {
    //Register
    String registerAccount(String name, int pin, double initialDeposit);

    // Login
    Account login(String accountNumber, int pin);

    // Deposit
    boolean deposit(double amount, Account account);

    // Withdraw
    boolean withdraw(double amount, Account account, int pin);

    double checkBalance(Account account);
}