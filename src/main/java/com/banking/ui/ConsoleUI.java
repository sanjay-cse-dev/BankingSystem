package com.banking.ui;

import com.banking.models.Account;
import com.banking.services.BankingServices;

import java.util.Scanner;

public class ConsoleUI {

    private final BankingServices bankingService;
    private final Scanner scanner;

    public ConsoleUI(BankingServices bankingService) {
        this.bankingService = bankingService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    registerUser();
                    break;

                case 2:
                    Account account = loginUser();

                    if (account != null) {
                        showAccountMenu(account);
                    }

                    break;

                case 3:
                    running = false;
                    System.out.println("Thank you for using Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    private void registerUser() {

        System.out.println("\n===== REGISTER =====");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter 4 Digit PIN: ");
        int pin = scanner.nextInt();

        System.out.print("Enter Initial Deposit: ");
        double initialDeposit = scanner.nextDouble();

        scanner.nextLine();

        String accountNumber = bankingService.registerAccount(name,pin,initialDeposit);

        if (accountNumber != null) {
            System.out.println("\nAccount created successfully!");
            System.out.println("Your Account Number: " + accountNumber);
        } else {
            System.out.println("\nAccount registration failed.");
        }
    }


    private Account loginUser() {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        Account account = bankingService.login(accountNumber, pin);

        if (account == null) {
            System.out.println("Invalid Account Number or PIN.");
            return null;
        }

        System.out.println("\nLogin successful!");
        System.out.println("Welcome, " + account.getAccountHolderName());

        return account;
    }


    private void showAccountMenu(Account account) {

        boolean loggedIn = true;

        while (loggedIn) {

            System.out.println("\n===== ACCOUNT MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    depositMoney(account);
                    break;

                case 2:
                    withdrawMoney(account);
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + bankingService.checkBalance(account));
                    break;

                case 4:
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    private void depositMoney(Account account) {

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        boolean success = bankingService.deposit(amount, account);

        if (success) {
            System.out.println("Deposited: ₹" + amount + "\nNew Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    private void withdrawMoney(Account account) {

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        boolean success = bankingService.withdraw(amount, account, pin);

        if (success) {
            System.out.println("Withdrawn: ₹" + amount + "\nNew Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed.");
        }
    }
}