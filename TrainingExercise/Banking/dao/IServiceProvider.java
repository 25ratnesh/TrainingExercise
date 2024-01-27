package com.hexaware.dao;

import com.hexaware.dto.BankAccount;
import com.hexaware.exception.AccountNumberInvalidException;
import com.hexaware.exception.InsufficientFundsException;
import com.hexaware.exception.NegativeAmountException;

public interface IServiceProvider {
    double checkBalance(long accountNumber);

    boolean deposit(long accountNumber, double amount) throws NegativeAmountException, AccountNumberInvalidException;

    boolean withdraw(long accountNumber, double amount) throws NegativeAmountException, AccountNumberInvalidException, InsufficientFundsException;

    boolean createAccount(String holderName, String type, double balance);

    boolean removeAccount(long accountNumber);

    BankAccount searchAccount(long accountNumber);
}
