package com.pismo.account.adapter;

import com.pismo.account.entity.AccountEntity;
import com.pismo.account.model.Account;
import com.pismo.account.ports.secondary.AccountDataAccessPort;
import com.pismo.account.repository.AccountRepository;
import com.pismo.utils.extensions.AccountExtensions;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.Optional;

@Singleton
public class AccountDataAccessAdapter implements AccountDataAccessPort {
    @Inject
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(AccountExtensions.toEntity(account)).toModel();
    }

    @Override
    public Account update(Account account) {
        return accountRepository.update(AccountExtensions.toEntity(account)).toModel();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id).map(AccountEntity::toModel);
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return accountRepository.existsByDocumentNumber(documentNumber);
    }
}
