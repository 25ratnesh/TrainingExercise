package com.hexaware.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hexaware.dao.IServiceProvider;
import com.hexaware.dao.ServiceProviderImpl;
import com.hexaware.dto.BankAccount;
import com.hexaware.exception.AccountNumberInvalidException;
import com.hexaware.exception.InsufficientFundsException;
import com.hexaware.exception.NegativeAmountException;

public class MainModule {
    private static final Logger LOGGER = Logger.getLogger(MainModule.class.getName());

    public static void main(String[] args) throws AccountNumberInvalidException, NegativeAmountException {
        List<BankAccount> accountList = new ArrayList<>();
        IServiceProvider serviceProvider = new ServiceProviderImpl(accountList);

        // Creating 3 accounts
        LOGGER.info("Creating 3 accounts");
        serviceProvider.createAccount("Ratnesh", "Savings", 5000.0);
        serviceProvider.createAccount("Akshat", "Checking", 3000.0);
        serviceProvider.createAccount("Kritik", "Savings", 8000.0);

        // Displaying initial account details
        displayAccountDetails("Initial", accountList);

        // Performing transactions
        try {
            LOGGER.info("Performing transactions");
            performTransactions(serviceProvider);
        } catch (NegativeAmountException | AccountNumberInvalidException | InsufficientFundsException e) {
            LOGGER.warning("Exception during transactions: " + e.getMessage());
        }

        // Displaying updated account details
        displayAccountDetails("Updated", accountList);

        LOGGER.info("Checking balance for account number 2");
        double balance = serviceProvider.checkBalance(2);
        LOGGER.info("Balance for Account 2: " + balance);

        LOGGER.info("Removing account number 3");
        boolean removeStatus = serviceProvider.removeAccount(3);
        if (removeStatus) {
            LOGGER.info("Account 3 removed successfully.");
        } else {
            LOGGER.warning("Failed to remove Account 3.");
        }

        LOGGER.info("Creating a new account");
        serviceProvider.createAccount("Bob Johnson", "Checking", 6000.0);

        // Displaying final account details
        displayAccountDetails("Final", accountList);
    }

    private static void displayAccountDetails(String status, List<BankAccount> accountList) {
        LOGGER.info(status + " Account Details:");
        for (BankAccount account : accountList) {
            LOGGER.info(account.toString());
        }
        LOGGER.info("");
    }

    private static void performTransactions(IServiceProvider serviceProvider)
            throws NegativeAmountException, AccountNumberInvalidException, InsufficientFundsException {
        // Deposit and Withdraw transactions
        LOGGER.info("Performing Deposit and Withdraw transactions");
        serviceProvider.deposit(1, 1000.0);
        serviceProvider.withdraw(2, 500.0);
        serviceProvider.deposit(3, 2000.0);
    }
}
