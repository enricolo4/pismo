package com.pismo.account.entity;

import com.pismo.account.model.Account;
import com.pismo.balance.entity.BalanceEntity;
import com.pismo.shared.Auditable;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "account")
public class AccountEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @NotNull
    private String documentNumber;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private BalanceEntity balance;

    public AccountEntity() {}

    public AccountEntity(Long id, String documentNumber, BalanceEntity balance) {
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

    public BalanceEntity getBalance() {
        return balance;
    }

    public void setBalance(BalanceEntity balance) {
        this.balance = balance;
    }

    public Account toModel() {
        return new Account(id, documentNumber, balance.toModel());
    }
}
