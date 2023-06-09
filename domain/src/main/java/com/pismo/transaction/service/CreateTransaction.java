package com.pismo.transaction.service;

import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.model.TransactionRequest;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class CreateTransaction implements CreateTransactionService {
    @Inject
    TransactionStrategyFactory transactionStrategyFactory;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Transaction create(TransactionRequest transactionRequest) {
        OperationType operationType = OperationType.fromOperationTypeId(transactionRequest.operationTypeId());

        return transactionStrategyFactory.findTransactionProcess(operationType)
            .process(transactionRequest);
    }
}
