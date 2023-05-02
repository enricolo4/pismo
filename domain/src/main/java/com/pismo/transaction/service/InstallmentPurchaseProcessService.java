package com.pismo.transaction.service;

import com.pismo.account.model.Account;
import com.pismo.account.service.GetAccountService;
import com.pismo.exceptions.TransactionNotExecutedException;
import com.pismo.transaction.model.Installment;
import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.model.TransactionRequest;
import com.pismo.transaction.ports.secondary.InstallmentDataAccessPort;
import com.pismo.transaction.ports.secondary.TransactionDataAccessPort;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;

@Singleton
public class InstallmentPurchaseProcessService implements TransactionProcessService {
    @Inject
    GetAccountService getAccountService;

    @Inject
    TransactionDataAccessPort transactionDataAccessPort;

    @Inject
    InstallmentDataAccessPort installmentDataAccessPort;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Transaction process(TransactionRequest transactionRequest) {
        Account account = getAccountService.byId(transactionRequest.accountId());

        try {
            Transaction transaction = transactionDataAccessPort.save(transactionRequest.toTransaction(account));
            BigDecimal installmentAmount = transactionRequest.amount().divide(BigDecimal.valueOf(transactionRequest.totalInstallment()));

            for (int installment = 1; installment <= transactionRequest.totalInstallment(); installment++) {
                saveInstallment(transaction, (long) installment, installmentAmount);
            }

            return transaction;
        } catch (Exception exception) {
            throw new TransactionNotExecutedException("Transaction not execute by Account=" + transactionRequest.accountId());
        }
    }

    private void saveInstallment(Transaction transaction, Long installment, BigDecimal installmentAmount) {

        LocalDate installmentDue = transaction.getEventDate().toLocalDate().plusMonths(installment - 1);

        Installment installmentToSave = new Installment(null, installmentAmount, installment, installmentDue, transaction);

        installmentDataAccessPort.save(installmentToSave);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.INSTALLMENT_PURCHASE;
    }
}
