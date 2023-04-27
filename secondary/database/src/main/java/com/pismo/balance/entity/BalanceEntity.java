package com.pismo.balance.entity;

import com.pismo.account.model.Balance;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "balance")
public class BalanceEntity {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull
    private BigDecimal balance;

    public BalanceEntity() {}

    public BalanceEntity(BigDecimal balance) {
        this.balance = balance;
    }

    public BalanceEntity(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Balance toModel() {
        return new Balance(getId(), getBalance());
    }
}
