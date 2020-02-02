package com.revolut.common.data.model;

public class Transaction {
    public static class CustomerAccount {
        String email;
        String nickName;

        public CustomerAccount() {
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }

    public enum State {
        initiated,
        success,
        failed
    }

    private CustomerAccount fromAccount;
    private CustomerAccount toAccount;
    private double amount;
    private State state;
    private String message;

    public Transaction() {
    }

    public CustomerAccount getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(CustomerAccount fromAccount) {
        this.fromAccount = fromAccount;
    }

    public CustomerAccount getToAccount() {
        return toAccount;
    }

    public void setToAccount(CustomerAccount toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
