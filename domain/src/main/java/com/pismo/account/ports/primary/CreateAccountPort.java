package com.pismo.account.ports.primary;


import com.pismo.account.model.Account;
import com.pismo.account.model.CreateAccountRequest;

public interface CreateAccountPort {
    Account create(CreateAccountRequest createAccountRequest);
}
