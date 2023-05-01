package com.pismo.account.service;

import com.pismo.account.model.Account;
import com.pismo.account.ports.secondary.AccountDataAccessPort;
import com.pismo.exceptions.AccountNotFoundException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.Optional;

@Singleton
public class GetAccount implements GetAccountService {
    @Inject
    private AccountDataAccessPort accountDataAccessPort;

    @Override
    public Account byId(Long accountId) {
        Optional<Account> account = accountDataAccessPort.findById(accountId);

        if(account.isEmpty()) throw new AccountNotFoundException("Account not found=" + accountId);

        return account.get();
    }
}
