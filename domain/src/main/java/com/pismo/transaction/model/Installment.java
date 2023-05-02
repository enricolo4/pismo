package com.pismo.transaction.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Installment {
    private Long id;
    private BigDecimal amount;
    private Long installment;
    private LocalDate installmentDue;
    private Transaction transaction;

    public Installment(Long id, BigDecimal amount, Long installment, LocalDate installmentDue, Transaction transaction) {
        this.id = id;
        this.amount = amount;
        this.installment = installment;
        this.installmentDue = installmentDue;
        this.transaction = transaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getInstallment() {
        return installment;
    }

    public void setInstallment(Long installment) {
        this.installment = installment;
    }

    public LocalDate getInstallmentDue() {
        return installmentDue;
    }

    public void setInstallmentDue(LocalDate installmentDue) {
        this.installmentDue = installmentDue;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
