package com.revolut.common.manager;

import com.revolut.common.data.entity.AccountEntity;
import com.revolut.common.data.model.Transaction;

public class TransactionManager {
    private static class BillPughSingleton {
        private static final TransactionManager instance = new TransactionManager();
    }

    public static TransactionManager getInstance() {
        return BillPughSingleton.instance;
    }

    private void transfer(Transaction transaction, AccountEntity source, AccountEntity destination) {
        if(!source.withdraw(transaction.getAmount())) {
            transaction.setState(Transaction.State.failed);
            transaction.setMessage("Could not withdraw from source account!");
        } else {
            if(!destination.deposit(transaction.getAmount())) {
                transaction.setState(Transaction.State.failed);
                transaction.setMessage("Could not deposit to destination account!");
                if(!source.deposit(transaction.getAmount())) {
                    transaction.setState(Transaction.State.failed);
                    transaction.setMessage("Could not deposit to destination account and amount could not be reverted back!");
                }
            } else {
                transaction.setState(Transaction.State.success);
                transaction.setMessage("Transaction successful!");
            }
        }
    }

    public Transaction execute(Transaction transaction) {
        CustomerManager customerManager = CustomerManager.getInstance();
        AccountEntity source = customerManager.get(transaction.getFromAccount().getEmail(), transaction.getFromAccount().getNickName());
        AccountEntity destination = customerManager.get(transaction.getToAccount().getEmail(), transaction.getToAccount().getNickName());

        if(source==null || destination==null) {
            transaction.setState(Transaction.State.failed);
            transaction.setMessage("Either or both accounts do not exist!");
            return transaction;
        }

        transfer(transaction, source, destination);

        return transaction;
    }
}
