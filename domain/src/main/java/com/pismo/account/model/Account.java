package com.pismo.account.model;

import com.pismo.balance.model.Balance;

public class Account {
    private Long id;
    private String documentNumber;
    private Balance balance;

    public Account() {}

    public Account(String documentNumber, Balance balance) {
        this.documentNumber = documentNumber;
        this.balance = balance;
    }

    public Account(Long id, String documentNumber, Balance balance) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
