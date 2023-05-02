package com.pismo.transaction.model;

import com.pismo.account.model.Account;
import java.math.BigDecimal;

public record TransactionRequest(
    Long accountId,
    Long operationTypeId,
    Long totalInstallment,
    BigDecimal amount
) {
    public Transaction toTransaction(Account account) {
        return new Transaction(
            null,
            operationTypeId,
            amount,
            totalInstallment,
            account
        );
    }
}
