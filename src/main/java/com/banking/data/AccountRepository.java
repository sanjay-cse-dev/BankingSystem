package com.banking.data;

import com.banking.models.Account;
import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    
    private Map<String, Account> accountsDB = new HashMap<>();

    public void saveAccount(Account account) {
        accountsDB.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accountsDB.get(accountNumber);
    }
}