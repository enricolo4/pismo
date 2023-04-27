package com.pismo.account.adapter;

import com.pismo.account.model.Account;
import com.pismo.account.ports.secondary.AccountDataAccessPort;
import com.pismo.account.repository.AccountRepository;
import com.pismo.utils.extensions.AccountExtensions;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AccountDataAccessAdapter implements AccountDataAccessPort {
    @Inject
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(AccountExtensions.toEntity(account)).toModel();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null).toModel();
    }
}
