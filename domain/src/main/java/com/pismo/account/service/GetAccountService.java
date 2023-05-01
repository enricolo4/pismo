package com.pismo.account.service;

import com.pismo.account.model.Account;

public interface GetAccountService {
    Account byId(Long accountId);
}
