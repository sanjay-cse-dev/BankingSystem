package com.banking;

import com.banking.data.AccountRepository;
import com.banking.services.BankingServiceImpl;
import com.banking.services.BankingServices;
import com.banking.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        // 1. Data layer initialize karo
        AccountRepository repo = new AccountRepository();

        // 2. Service layer initialize karo aur usko repo do
         BankingServices service = new BankingServiceImpl(repo);

        // 3. UI layer initialize karo aur usko service do
        ConsoleUI ui = new ConsoleUI(service);

        // 4. App start karo
        ui.start();
    }
}