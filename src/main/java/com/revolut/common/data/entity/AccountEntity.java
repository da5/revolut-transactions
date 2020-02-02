package com.revolut.common.data.entity;

public class AccountEntity {
    final private int id;
    final private String accountNickName;
    private double balance;

    public AccountEntity(int id, String accountNickName, double balance) {
        this.id = id;
        this.accountNickName = accountNickName;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getAccountNickName() {
        return accountNickName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        boolean ack = false;
        System.out.println("Balance in " + accountNickName +" account before deposit " + balance);
        synchronized (this) {
            System.out.println("About to deposit...");
            balance += amount;
            ack = true;
        }
        System.out.println("Balance in " + accountNickName +" account after deposit " + balance + " " + ack);
        return ack;
    }

    public boolean withdraw(double amount) {
        boolean ack = false;
        System.out.println("Balance in "+ accountNickName +" account before withdrawal " + balance);
        synchronized (this) {
            if(balance>=amount) {
                System.out.println("About to withdraw...");
                balance -= amount;
                ack = true;
            }
        }
        System.out.println("Balance in "+ accountNickName +" account after withdrawal " + balance+ " " + ack);
        return ack;
    }
}
