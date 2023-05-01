package com.pismo.transaction.controller;

import com.pismo.transaction.dto.CreateTransactionRequestDTO;
import com.pismo.transaction.dto.TransactionResponseDTO;
import com.pismo.transaction.dto.TransactionsResponseDTO;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.ports.primary.CreateTransactionPort;
import com.pismo.transaction.ports.primary.GetTransactionPort;
import com.pismo.transaction.utils.TransactionExtensionDTO;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;
import javax.validation.Valid;

@Controller("transactions")
@Introspected(classes = CreateTransactionRequestDTO.class)
public class TransactionController {
    @Inject
    private CreateTransactionPort createTransactionPort;

    @Inject
    private GetTransactionPort getTransactionPort;

    @Post
    @Status(HttpStatus.CREATED)
    TransactionResponseDTO create(@Body @Valid CreateTransactionRequestDTO createTransactionRequestDTO) {
        Transaction transaction = createTransactionPort.create(createTransactionRequestDTO.toModel());

        return TransactionExtensionDTO.responseDTO(transaction);
    }

    @Get("/{id}")
    TransactionResponseDTO getById(@PathVariable Long id) {
        Transaction transaction = getTransactionPort.getById(id);

        return TransactionExtensionDTO.responseDTO(transaction);
    }

    @Get("/account/{accountId}")
    TransactionsResponseDTO getByAccountId(@PathVariable Long accountId) {
        List<Transaction> transactions = getTransactionPort.getByAccountId(accountId);

        return TransactionExtensionDTO.responseDTO(transactions);
    }
}
