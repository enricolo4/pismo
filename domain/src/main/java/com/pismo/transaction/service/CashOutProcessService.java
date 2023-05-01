package com.pismo.transaction.service;

import com.pismo.account.model.Account;
import com.pismo.balance.model.Balance;
import com.pismo.account.ports.secondary.AccountDataAccessPort;
import com.pismo.account.service.GetAccountService;
import com.pismo.balance.service.UpdateBalance;
import com.pismo.balance.service.UpdateBalanceService;
import com.pismo.exceptions.WrongTransactionAmountException;
import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.model.TransactionRequest;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class CashOutProcessService implements TransactionProcessService {
    @Inject
    private ExecuteTransactionService executeTransactionService;

    @Inject
    private GetAccountService getAccountService;

    @Inject
    private UpdateBalanceService updateBalanceService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Transaction process(TransactionRequest transactionRequest) {
        Account account = getAccountService.byId(transactionRequest.accountId());

        if(transactionRequest.amount().compareTo(account.getBalance().getValue()) > 0) {
            throw new WrongTransactionAmountException("Amount greater than Balance for Account=" + transactionRequest.accountId());
        }

        updateBalanceService.cashOut(account.getBalance(), transactionRequest.amount());

        return executeTransactionService.execute(transactionRequest.toTransaction(account));
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.CASH_OUT;
    }
}
