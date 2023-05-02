package com.pismo.account.usecase;

import com.pismo.account.model.Account;
import com.pismo.account.model.CreateAccountRequest;
import com.pismo.account.ports.primary.CreateAccountPort;
import com.pismo.account.ports.secondary.AccountDataAccessPort;
import com.pismo.exceptions.AccountExistsException;
import jakarta.inject.*;
import jakarta.transaction.Transactional;

@Singleton
public class CreateAccountUseCase implements CreateAccountPort {
    @Inject
    private AccountDataAccessPort accountDataAccessPort;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Account create(CreateAccountRequest createAccountRequest) {
        if(accountDataAccessPort.existsByDocumentNumber(createAccountRequest.documentNumber()))
            throw new AccountExistsException("Account exists");

        return accountDataAccessPort.save(createAccountRequest.toModel());
    }
}
