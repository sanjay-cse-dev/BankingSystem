package com.banking.services;

import com.banking.models.Account;
import com.banking.data.AccountRepository;
import java.util.UUID;

public class BankingServiceImpl implements BankingServices{

    private AccountRepository repository;


    public BankingServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public String registerAccount(String name, int pin, double initialDeposit){
        if (initialDeposit < 0) {
            System.out.println("Error: Initial deposit cannot be negative.");
            return null;
        }

        if (pin < 1000 || pin > 9999) {
            System.out.println("Invalid PIN");
            return null;
        }

        String newAccountNumber = UUID.randomUUID().toString().substring(0, 8);

        Account newAccount = new Account(newAccountNumber, name, pin, initialDeposit);

        repository.saveAccount(newAccount);

        return newAccountNumber;
    }


    @Override
    public Account login(String accountNumber, int pin){
        Account account = repository.getAccount(accountNumber);
        if(account != null){
            if(account.verifyPin(pin)){
                return account;
            }
            else{
                return null;
            }
        }else{
            return null;
        }
    }


    @Override
    public boolean deposit(double amount, Account account){
        return amount > 0 && account.deposit(amount);
    }


    @Override
    public boolean withdraw(double amount, Account account, int pin){
        if (!account.verifyPin(pin)) {
            System.out.println("Enter Valid PIN!");
            return false;
        }

        if (!account.withdraw(amount)) {
            System.out.println("Insufficient Balance!");
            return false;
        }
        return true;
    }


    @Override
    public double checkBalance(Account account){
        return account.getBalance();
    }

}