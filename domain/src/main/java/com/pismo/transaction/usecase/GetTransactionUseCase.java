package com.pismo.transaction.usecase;

import com.pismo.exceptions.TransactionNotFoundException;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.ports.primary.GetTransactionPort;
import com.pismo.transaction.ports.secondary.TransactionDataAccessPort;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class GetTransactionUseCase implements GetTransactionPort {
    @Inject
    TransactionDataAccessPort transactionDataAccessPort;

    @Override
    public Transaction getById(Long id) {
        Optional<Transaction> transaction = transactionDataAccessPort.findById(id);

        if(transaction.isEmpty())
            throw new TransactionNotFoundException("Transaction not found=" + id);

        return transaction.get();
    }

    @Override
    public List<Transaction> getByAccountId(Long accountId) {
        return transactionDataAccessPort.findByAccountId(accountId);
    }
}
