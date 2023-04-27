package com.pismo.account.usecase;

import com.pismo.account.model.Account;
import com.pismo.account.model.CreateAccountRequest;
import com.pismo.account.ports.primary.CreateAccountPort;
import com.pismo.account.ports.secondary.AccountDataAccessPort;
import jakarta.inject.*;

@Singleton
public class CreateAccountUseCase implements CreateAccountPort {
    @Inject
    private AccountDataAccessPort accountDataAccessPort;

    @Override
    public Account create(CreateAccountRequest createAccountRequest) {
        return accountDataAccessPort.save(createAccountRequest.toModel());
    }
}
