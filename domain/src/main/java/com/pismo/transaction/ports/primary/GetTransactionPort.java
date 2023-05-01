package com.pismo.transaction.ports.primary;

import com.pismo.transaction.model.Transaction;
import java.util.List;

public interface GetTransactionPort {
    Transaction getById(Long id);
    List<Transaction> getByAccountId(Long accountId);
}
