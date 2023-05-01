package com.pismo.utils.extensions;

import com.pismo.transaction.entity.TransactionEntity;
import com.pismo.transaction.model.Transaction;
import java.math.BigDecimal;
import java.util.List;

public final class TransactionExtensions {
    public static TransactionEntity toEntity(Transaction transaction) {
        long multiplier;
        List<Long> negativeOperationTypeIds = List.of(1L, 2L, 3L);

        if(negativeOperationTypeIds.contains(transaction.operationTypeId()))
            multiplier = -1L;
        else
            multiplier = 1L;

        return new TransactionEntity(
            transaction.id(),
            transaction.operationTypeId(),
            transaction.amount().multiply(BigDecimal.valueOf(multiplier)),
            AccountExtensions.toEntity(transaction.account())
        );
    }
}
