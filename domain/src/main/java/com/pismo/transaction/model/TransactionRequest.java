package com.pismo.transaction.model;

import com.pismo.account.model.Account;
import java.math.BigDecimal;

public record TransactionRequest(
    Long accountId,
    Long operationTypeId,
    BigDecimal amount
) {
    public Transaction toTransaction(Account account) {
        return new Transaction(
            null,
            operationTypeId,
            amount,
            account
        );
    }
}
