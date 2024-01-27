package com.hexaware.dao;

import java.util.List;

import com.hexaware.dto.BankAccount;
import com.hexaware.exception.AccountNumberInvalidException;
import com.hexaware.exception.InsufficientFundsException;
import com.hexaware.exception.NegativeAmountException;

public class ServiceProviderImpl implements IServiceProvider {
    private List<BankAccount> accountList;

    public ServiceProviderImpl(List<BankAccount> accountList) {
        this.accountList = accountList;
    }

    @Override
    public BankAccount searchAccount(long accountNumber) {
        for (BankAccount account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    @Override
    public double checkBalance(long accountNumber) {
        BankAccount reqAccount = searchAccount(accountNumber);
        return (reqAccount != null) ? reqAccount.getBalance() : -1;
    }

    @Override
    public boolean deposit(long accountNumber, double amount) throws NegativeAmountException, AccountNumberInvalidException {
        if (amount < 0) {
            throw new NegativeAmountException("Deposit amount cannot be negative.");
        }

        BankAccount reqAccount = searchAccount(accountNumber);
        if (reqAccount != null) {
            reqAccount.setBalance(reqAccount.getBalance() + amount);
            return true;
        }

        throw new AccountNumberInvalidException("Account does not exist.");
    }

    @Override
    public boolean withdraw(long accountNumber, double amount)
            throws NegativeAmountException, AccountNumberInvalidException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeAmountException("Withdrawal amount cannot be negative.");
        }

        BankAccount reqAccount = searchAccount(accountNumber);
        if (reqAccount != null) {
            if (reqAccount.getBalance() >= amount) {
                reqAccount.setBalance(reqAccount.getBalance() - amount);
                return true;
            } else {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
        }

        throw new AccountNumberInvalidException("Account does not exist.");
    }

    @Override
    public boolean createAccount(String holderName, String type, double balance) {
        long newAccountNumber = accountList.isEmpty() ? 1 : accountList.get(accountList.size() - 1).getAccountNumber() + 1;
        BankAccount newAccObj = new BankAccount(holderName, type, balance);
        accountList.add(newAccObj);
        return true;
    }

    @Override
    public boolean removeAccount(long accountNumber) {
        BankAccount reqAccount = searchAccount(accountNumber);
        if (reqAccount != null) {
            accountList.remove(reqAccount);
            return true;
        }
        return false;
    }
}
