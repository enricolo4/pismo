package com.pismo.account.usecase;

import com.pismo.account.model.Account;
import com.pismo.account.ports.secondary.AccountDataAccessPort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;

public class UpdateBalance implements UpdateBalanceService {
    @Inject
    AccountDataAccessPort accountDataAccessPort;

    @Override
    @Transactional
    public Account cashIn(Account account, BigDecimal amount) {

        return accountDataAccessPort.update(account.cashIn(amount));
    }

    @Override
    @Transactional
    public Account cashOut(Account account, BigDecimal amount) {
        return accountDataAccessPort.update(account.cashOut(amount));
    }
}
