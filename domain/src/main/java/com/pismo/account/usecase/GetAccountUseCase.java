package com.pismo.account.usecase;

import com.pismo.account.model.Account;
import com.pismo.account.ports.primary.GetAccountPort;
import com.pismo.account.ports.secondary.AccountDataAccessPort;
import com.pismo.exceptions.AccountNotFoundException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.Optional;

@Singleton
public class GetAccountUseCase implements GetAccountPort {
    @Inject
    private AccountDataAccessPort accountDataAccessPort;

    @Override
    public Account getById(Long id) {

        Optional<Account> account = accountDataAccessPort.findById(id);

        if(account.isEmpty())
            throw new AccountNotFoundException("Account not found=" + id);

        return account.get();
    }
}
