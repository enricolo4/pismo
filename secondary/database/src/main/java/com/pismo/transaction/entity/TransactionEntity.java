package com.pismo.transaction.entity;

import com.pismo.account.entity.AccountEntity;
import com.pismo.shared.Auditable;
import com.pismo.transaction.model.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "transactions")
public class TransactionEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Long operationTypeId;
    private BigDecimal amount;
    private Long totalInstallment;
    @OneToOne
    private AccountEntity account;

    public TransactionEntity() {}

    public TransactionEntity(Long id, Long operationTypeId, BigDecimal amount, Long totalInstallment, AccountEntity account) {
        this.id = id;
        this.operationTypeId = operationTypeId;
        this.amount = amount;
        this.totalInstallment = totalInstallment;
        this.account = account;
    }

    public TransactionEntity(Long id, Long operationType, BigDecimal amount, AccountEntity account) {
        this.id = id;
        this.operationTypeId = operationType;
        this.amount = amount;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOperationType() {
        return operationTypeId;
    }

    public void setOperationType(Long operationType) {
        this.operationTypeId = operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public Long getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public Long getTotalInstallment() {
        return totalInstallment;
    }

    public void setTotalInstallment(Long totalInstallment) {
        this.totalInstallment = totalInstallment;
    }

    public Transaction toModel() {
        return new Transaction(
            id,
            operationTypeId,
            amount,
            getCreatedAt() == null ? null : LocalDateTime.ofInstant(getCreatedAt(), ZoneOffset.UTC),
            totalInstallment,
            account.toModel()
        );
    }
}
