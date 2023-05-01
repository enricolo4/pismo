package com.pismo.transaction.usecase;

import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.model.TransactionRequest;
import com.pismo.transaction.ports.primary.CreateTransactionPort;
import com.pismo.transaction.service.CreateTransactionService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CreateTransactionUseCase implements CreateTransactionPort  {
    @Inject
    CreateTransactionService createTransactionService;

    @Override
    public Transaction create(TransactionRequest transactionRequest) {
        return createTransactionService.create(transactionRequest);
    }
}
