package com.pismo.balance.ports.secondary;

import com.pismo.balance.model.Balance;

public interface BalanceDataAccessPort {
    Balance update(Balance balance);
}
