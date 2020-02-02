package com.revolut.common.data.model;

import com.revolut.common.data.entity.AccountEntity;

public class Account {
    private String accountNickName;
    private double balance;

    public Account(AccountEntity accountEntity) {
        this.accountNickName = accountEntity.getAccountNickName();
        this.balance = accountEntity.getBalance();
    }

    public Account() {
    }

    public void setAccountNickName(String accountNickName) {
        this.accountNickName = accountNickName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNickName() {
        return accountNickName;
    }

    public double getBalance() {
        return balance;
    }
}
