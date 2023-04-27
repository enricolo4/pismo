package com.pismo.utils.extensions;

import com.pismo.account.entity.AccountEntity;
import com.pismo.account.model.Account;
import com.pismo.account.model.Balance;
import com.pismo.balance.entity.BalanceEntity;

public final class AccountExtensions {
    public static AccountEntity toEntity(Account account) {
        return new AccountEntity(account.getId(), account.getDocumentNumber(), balanceEntity(account.getBalance()));
    }

    private static BalanceEntity balanceEntity(Balance balance) {
        return new BalanceEntity(balance.id(), balance.value());
    }
}
