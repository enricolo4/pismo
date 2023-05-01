package com.pismo.transaction.adapter;

import com.pismo.transaction.entity.TransactionEntity;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.ports.secondary.TransactionDataAccessPort;
import com.pismo.transaction.repository.TransactionRepository;
import com.pismo.utils.extensions.TransactionExtensions;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class TransactionDataAccessAdapter implements TransactionDataAccessPort {
    @Inject
    private TransactionRepository transactionRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(TransactionExtensions.toEntity(transaction)).toModel();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id).map(TransactionEntity::toModel);
    }

    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId).stream().map(TransactionEntity::toModel).toList();
    }
}
