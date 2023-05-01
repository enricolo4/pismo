package com.pismo.utils.extensions;

import com.pismo.balance.entity.BalanceEntity;
import com.pismo.balance.model.Balance;

public final class BalanceExtensions {
    public static BalanceEntity toEntity(Balance balance) {
        return new BalanceEntity(balance.getId(), balance.getValue());
    }
}
