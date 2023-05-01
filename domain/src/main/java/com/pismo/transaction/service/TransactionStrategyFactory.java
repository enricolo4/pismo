package com.pismo.transaction.service;

import com.pismo.transaction.model.OperationType;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Singleton
public class TransactionStrategyFactory {
    private Map<OperationType, TransactionProcessService> transactionProcessServices;

    @Inject
    public TransactionStrategyFactory(Set<TransactionProcessService> transactionProcessServiceSet) {
        createTransactionStrategy(transactionProcessServiceSet);
    }

    public TransactionProcessService findTransactionProcess(OperationType operationType) {
        return transactionProcessServices.get(operationType);
    }

    private void createTransactionStrategy(Set<TransactionProcessService> transactionProcessStrategySet) {
        transactionProcessServices = new HashMap<OperationType, TransactionProcessService>();
        transactionProcessStrategySet.forEach(
            strategy -> transactionProcessServices.put(strategy.getOperationType(), strategy)
        );
    }
}
