package com.revolut.common.data.model;

import com.revolut.common.data.entity.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private List<Account> accounts;

    public Customer(CustomerEntity customerEntity) {
        this.firstName = customerEntity.getFirstName();
        this.lastName = customerEntity.getLastName();
        this.email = customerEntity.getEmail();
        this.accounts = customerEntity.getAccountEntities().values()
                .stream().map(Account::new).collect(Collectors.toList());
    }

    public Customer() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
