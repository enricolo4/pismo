package com.pismo.transaction.service;

import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.model.TransactionRequest;

public interface TransactionProcessService {
    Transaction process(TransactionRequest transactionRequest);
    OperationType getOperationType();
}
