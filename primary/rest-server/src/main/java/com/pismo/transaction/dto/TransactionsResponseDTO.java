package com.pismo.transaction.dto;

import java.util.List;

public record TransactionsResponseDTO(
    List<TransactionResponseDTO> transactions
) {}
