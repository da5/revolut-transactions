package com.revolut.common.data.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Map<String, AccountEntity> accountEntityMap;

    public CustomerEntity(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accountEntityMap = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean addAccount(AccountEntity accountEntity) {
        boolean acknowledgement = true;
        synchronized (this) {
            acknowledgement = !this.accountEntityMap.containsKey(accountEntity.getAccountNickName());
            if(acknowledgement) {
                this.accountEntityMap.put(accountEntity.getAccountNickName(), accountEntity);
            }
        }
        return acknowledgement;
    }

    public Map<String, AccountEntity> getAccountEntities() {
        return accountEntityMap;
    }
}
