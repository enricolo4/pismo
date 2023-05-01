package com.pismo.transaction.service;

import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.model.TransactionRequest;
import jakarta.inject.Singleton;

@Singleton
public class InstallmentPurchaseProcessService implements TransactionProcessService {
    @Override
    public Transaction process(TransactionRequest transactionRequest) {
        return null;
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.INSTALLMENT_PURCHASE;
    }
}
