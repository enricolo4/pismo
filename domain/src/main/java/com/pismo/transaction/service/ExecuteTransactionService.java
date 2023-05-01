package com.pismo.transaction.service;

import com.pismo.transaction.model.Transaction;

public interface ExecuteTransactionService {
    Transaction execute(Transaction transaction);
}
