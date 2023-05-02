package com.pismo.transaction.dto;

import java.math.BigDecimal;

public record InstallmentResponseDTO(
    Long id,
    BigDecimal amount,
    Long transactionId,
    Long installment,
    String installmentDue
) {}
