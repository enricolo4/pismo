package com.pismo.balance.adapter;

import com.pismo.balance.model.Balance;
import com.pismo.balance.ports.secondary.BalanceDataAccessPort;
import com.pismo.balance.repository.BalanceRepository;
import com.pismo.utils.extensions.BalanceExtensions;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class BalanceDataAccessAdapter implements BalanceDataAccessPort {
    @Inject
    BalanceRepository balanceRepository;

    @Override
    public Balance update(Balance balance) {
        return balanceRepository.update(BalanceExtensions.toEntity(balance)).toModel();
    }
}
