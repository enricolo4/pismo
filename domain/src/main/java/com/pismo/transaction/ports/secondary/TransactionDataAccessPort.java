package com.pismo.transaction.ports.secondary;

import com.pismo.transaction.model.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionDataAccessPort {
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(Long id);
    List<Transaction> findByAccountId(Long accountId);
}
