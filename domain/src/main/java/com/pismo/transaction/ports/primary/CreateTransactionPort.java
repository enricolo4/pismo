package com.pismo.transaction.ports.primary;

import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.model.TransactionRequest;

public interface CreateTransactionPort {
    Transaction create(TransactionRequest transactionRequest);
}
