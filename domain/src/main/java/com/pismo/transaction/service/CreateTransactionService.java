package com.pismo.transaction.service;

import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.model.TransactionRequest;

public interface CreateTransactionService {
    Transaction create(TransactionRequest transactionRequest);
}
