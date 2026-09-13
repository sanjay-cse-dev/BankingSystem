package com.banking.ui;

import com.banking.models.Account;
import com.banking.services.BankingServices;
import java.util.Scanner;

public class ConsoleUI {
    private BankingServices bankingService;
    private Scanner scanner;

    public ConsoleUI(BankingServices bankingService) {
        this.bankingService = bankingService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("1) Register\n2) Login\n3) Exit\n---- CHOSE OPTIONS ----");

        int c = scanner.nextInt();
        if(c == 1){
            System.out.println("Enter your Name: ");
            String name = scanner.next();
            System.out.println("Enter your PIN: ");
            int pin = scanner.nextInt();
            System.out.println("Enter Initial Amount: ");
            double initialDeposit = scanner.nextDouble();
            String accountNumber = bankingService.registerAccount(name, pin, initialDeposit);
            if(accountNumber == null){
                start();
            }else{
                System.out.println("Registered Successfully !");
                System.out.println("--- Your Account Detail ---");
                System.out.println("Name : " +name+ "\nAccount Number : " +accountNumber);
                System.out.println("Remember these details for Operations");
                start();
            }
        }else if(c == 2){
            System.out.println("Enter your account Number: ");
            String accountNumber = scanner.next();
            System.out.println("Enter your 4 digit PIN: ");
            int pin = scanner.nextInt();
            Account account = bankingService.login(accountNumber,pin);
            if(account == null){
                System.out.println("Please Enter correct account number and PIN !");
                start();
            }else{
                System.out.println("Login Successful !");
                while (true) {
                    System.out.println("\n--- Banking System ---");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("0. Exit");
                    System.out.print("Choose an option: ");

                    int choice = scanner.nextInt();
                    if(choice == 0) break;
                    if(choice == 1){
                        System.out.println("Enter amount you want to deposit: ");
                        double amount = scanner.nextDouble();
                        bankingService.deposit(amount,account);
                        System.out.println("Your have added: "+amount+"\nYour total balance is : "+account.getBalance());
                    }else if(choice == 2){
                        System.out.println("Enter Amount to withdraw : ");
                        double amount = scanner.nextDouble();
                        System.out.println("Enter four digit PIN again : ");
                        pin = scanner.nextInt();
                        boolean success = bankingService.withdraw(amount,account, pin);
                        if(success){
                            System.out.println(
                                    "You have withdrawn: " + amount +
                                    "\nYour total balance is: " + account.getBalance()
                            );
                        }else{
                            System.out.println("Invalid deposit amount!");
                        }
                    }else{
                        System.out.println("Invalid !");
                        start();
                    }
                }
            }
        }else if(c == 3){
            return;
        }else{
            System.out.println("Invalid Input!");
            start();
        }
    }

}
