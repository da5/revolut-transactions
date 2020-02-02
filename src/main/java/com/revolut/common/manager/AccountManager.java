package com.revolut.common.manager;

import com.revolut.common.data.entity.AccountEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class AccountManager {
    private Map<Integer, AccountEntity> accountEntityMap;
    private AtomicInteger idCounter;

    AccountManager() {
        accountEntityMap = new HashMap<>();
        idCounter = new AtomicInteger();
    }

    AccountEntity createAccount(String nickName, double initialBalance) {
        AccountEntity accountEntity = new AccountEntity(idCounter.incrementAndGet(), nickName, initialBalance);
        accountEntityMap.put(accountEntity.getId(), accountEntity);
        return accountEntity;
    }

    AccountEntity getAccount(int accountId) {
        return accountEntityMap.get(accountId);
    }
}
