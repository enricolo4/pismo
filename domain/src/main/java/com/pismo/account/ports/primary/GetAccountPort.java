package com.pismo.account.ports.primary;

import com.pismo.account.model.Account;

public interface GetAccountPort {
    Account getById(Long id);
}
