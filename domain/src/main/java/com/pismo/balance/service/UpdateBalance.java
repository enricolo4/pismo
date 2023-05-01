package com.pismo.balance.service;

import com.pismo.balance.model.Balance;
import com.pismo.balance.ports.secondary.BalanceDataAccessPort;
import jakarta.inject.Inject;
import java.math.BigDecimal;

public class UpdateBalance implements UpdateBalanceService {
    @Inject
    BalanceDataAccessPort balanceDataAccessPort;

    @Override
    public Balance cashIn(Balance balance, BigDecimal amount) {
        Balance newBalance = balance.cashIn(amount);

        return balanceDataAccessPort.update(newBalance);
    }

    @Override
    public Balance cashOut(Balance balance, BigDecimal amount) {
        Balance newBalance = balance.cashOut(amount);

        return balanceDataAccessPort.update(newBalance);
    }
}
