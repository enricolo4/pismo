package com.pismo.transaction.entity;

import com.pismo.shared.Auditable;
import com.pismo.transaction.model.Installment;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "installments")
public class InstallmentEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private BigDecimal amount;
    private Long installment;
    private LocalDate installmentDue;
    @ManyToOne
    private TransactionEntity transaction;

    public InstallmentEntity() {
    }

    public InstallmentEntity(Long id, BigDecimal amount, Long installment, LocalDate installmentDue, TransactionEntity transaction) {
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

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public Installment toModel() {
        return new Installment(
            getId(),
            getAmount(),
            getInstallment(),
            getInstallmentDue(),
            getTransaction().toModel()
        );
    }
}
