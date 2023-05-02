package com.pismo.transaction.dto;

import java.math.BigDecimal;

public record TransactionResponseDTO(
    Long id,
    Long accountId,
    Long operationTypeId,
    BigDecimal amount,
    Long totalInstallment,
    String eventDate
) {}
