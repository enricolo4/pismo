package com.pismo.utils.extensions;

import com.pismo.transaction.entity.TransactionEntity;
import com.pismo.transaction.model.Transaction;
import java.math.BigDecimal;
import java.util.List;

public final class TransactionExtensions {
    public static TransactionEntity toEntity(Transaction transaction) {
        long multiplier;
        List<Long> negativeOperationTypeIds = List.of(1L, 2L, 3L);

        if(negativeOperationTypeIds.contains(transaction.getOperationTypeId()))
            multiplier = -1L;
        else
            multiplier = 1L;

        return new TransactionEntity(
            transaction.getId(),
            transaction.getOperationTypeId(),
            transaction.getAmount().multiply(BigDecimal.valueOf(multiplier)),
            transaction.getTotalInstallment(),
            AccountExtensions.toEntity(transaction.getAccount())
        );
    }
}
