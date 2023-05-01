package com.pismo.transaction.entity;

import com.pismo.account.entity.AccountEntity;
import com.pismo.shared.Auditable;
import com.pismo.transaction.model.Transaction;
import java.math.BigDecimal;
import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "transaction")
public class TransactionEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private Long operationTypeId;
    private BigDecimal amount;
    @OneToOne
    private AccountEntity account;

    public TransactionEntity() {
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

    public Transaction toModel() {
        return new Transaction(id, operationTypeId, amount, account.toModel());
    }
}
