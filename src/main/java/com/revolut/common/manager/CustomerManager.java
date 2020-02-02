package com.revolut.common.manager;

import com.revolut.common.data.entity.AccountEntity;
import com.revolut.common.data.entity.CustomerEntity;
import com.revolut.common.data.model.Account;
import com.revolut.common.data.model.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerManager {

    private Map<Integer, CustomerEntity> customerEntityMap;
    private Map<String, CustomerEntity> emailCustomerEntityMap;
    private AtomicInteger idCounter;
    private AccountManager accountManager;

    private static class BillPughSingleton {
        private static final CustomerManager instance = new CustomerManager();
    }

    public static CustomerManager getInstance() {
        return BillPughSingleton.instance;
    }

    private CustomerManager() {
        accountManager = new AccountManager();
        customerEntityMap = new HashMap<>();
        emailCustomerEntityMap = new HashMap<>();
        idCounter = new AtomicInteger();
    }

    public Customer get(String email) {
        Customer customer = null;
        CustomerEntity entity = emailCustomerEntityMap.get(email);
        if(entity!=null) {
            customer = new Customer(entity);
        }
        return customer;
    }


    AccountEntity get(String email, String nickName) {
        AccountEntity accountEntity = null;
        CustomerEntity entity = emailCustomerEntityMap.get(email);
        if(entity!=null && entity.getAccountEntities().containsKey(nickName)) {
            accountEntity = entity.getAccountEntities().get(nickName);
        }
        return accountEntity;
    }

    public Customer create(String firstName, String lastName, String email) {
        if(emailCustomerEntityMap.containsKey(email)) {
            return null;
        }
        CustomerEntity customerEntity = new CustomerEntity(idCounter.incrementAndGet(), firstName, lastName, email);
        customerEntityMap.put(customerEntity.getId(), customerEntity);
        emailCustomerEntityMap.put(customerEntity.getEmail(), customerEntity);
        return new Customer(customerEntity);
    }

    public Account createAccount(String email, String nickName, double initialBalance) {
        Account account = null;
        CustomerEntity customerEntity = emailCustomerEntityMap.get(email);
        if(customerEntity!=null) {
            AccountEntity accountEntity = accountManager.createAccount(nickName, initialBalance);
            customerEntity.addAccount(accountEntity);
            account = new Account(accountEntity);
        }
        return account;
    }
}
