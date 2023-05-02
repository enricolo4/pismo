package com.pismo.transaction.model;

import com.pismo.account.model.Account;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Long operationTypeId;
    private BigDecimal amount;
    private LocalDateTime eventDate;
    private Long totalInstallment;
    private Account account;

    public Transaction(Long id, Long operationTypeId, BigDecimal amount, Long totalInstallment, Account account) {
        this.id = id;
        this.operationTypeId = operationTypeId;
        this.amount = amount;
        this.totalInstallment = totalInstallment;
        this.account = account;
    }

    public Transaction(Long id, Long operationTypeId, BigDecimal amount, LocalDateTime eventDate, Long totalInstallment, Account account) {
        this.id = id;
        this.operationTypeId = operationTypeId;
        this.amount = amount;
        this.eventDate = eventDate;
        this.totalInstallment = totalInstallment;
        this.account = account;
    }

    public Long getTotalInstallment() {
        return totalInstallment;
    }

    public void setTotalInstallment(Long totalInstallment) {
        this.totalInstallment = totalInstallment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
