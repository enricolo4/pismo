package com.pismo.transaction.utils;

import com.pismo.transaction.dto.TransactionResponseDTO;
import com.pismo.transaction.dto.TransactionsResponseDTO;
import com.pismo.transaction.model.Transaction;
import java.util.List;

public class TransactionExtensionDTO {
    public static TransactionResponseDTO responseDTO(Transaction transaction) {
        return new TransactionResponseDTO(
            transaction.id(),
            transaction.account().getId(),
            transaction.operationTypeId(),
            transaction.amount()
        );
    }

    public static TransactionsResponseDTO responseDTO(List<Transaction> transactions) {
        List<TransactionResponseDTO> transactionsResponseDTO = transactions
            .stream()
            .map(TransactionExtensionDTO::responseDTO)
            .toList();

        return new TransactionsResponseDTO(transactionsResponseDTO);
    }
}
