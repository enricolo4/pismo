package com.pismo.transaction.service;

import com.pismo.exceptions.TransactionNotExecutedException;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.ports.secondary.TransactionDataAccessPort;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ExecuteTransaction implements ExecuteTransactionService {
    @Inject
    private TransactionDataAccessPort transactionDataAccessPort;

    @Override
    public Transaction execute(Transaction transaction) {
        try {
            return transactionDataAccessPort.save(transaction);
        } catch (Exception exception) {
            throw new TransactionNotExecutedException("Transaction not execute by Account=" + transaction.account().getId());
        }
    }
}
