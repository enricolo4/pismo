package com.pismo.transaction.dto;

import com.pismo.transaction.model.TransactionRequest;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public record CreateTransactionRequestDTO(
    @NotNull
    Long accountId,
    @NotNull
    Long operationTypeId,
    @NotNull
    BigDecimal amount
) {
    public TransactionRequest toModel() {
        return new TransactionRequest(accountId, operationTypeId, amount);
    }
}
