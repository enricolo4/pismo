package com.pismo.utils.extensions;

import com.pismo.account.entity.AccountEntity;
import com.pismo.account.model.Account;

public final class AccountExtensions {
    public static AccountEntity toEntity(Account account) {
        return new AccountEntity(account.getId(), account.getDocumentNumber(), BalanceExtensions.toEntity(account.getBalance()));
    }
}
