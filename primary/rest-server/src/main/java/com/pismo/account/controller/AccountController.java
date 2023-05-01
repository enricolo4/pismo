package com.pismo.account.controller;


import com.pismo.account.dto.AccountResponseDTO;
import com.pismo.account.dto.CreateAccountRequestDTO;
import com.pismo.account.model.Account;
import com.pismo.account.ports.primary.CreateAccountPort;
import com.pismo.account.ports.primary.GetAccountPort;
import com.pismo.account.utils.AccountExtensionDTO;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import javax.validation.Valid;

@Controller("accounts")
@Introspected(classes = CreateAccountRequestDTO.class)
public class AccountController {
    @Inject
    private CreateAccountPort createAccount;

    @Inject
    private GetAccountPort getAccount;

    @Post
    @Status(HttpStatus.CREATED)
    AccountResponseDTO create(@Body @Valid CreateAccountRequestDTO createAccountRequestDTO) {
        Account account = createAccount.create(createAccountRequestDTO.toModel());
        return AccountExtensionDTO.toResponseDTO(account);
    }

    @Get("/{id}")
    AccountResponseDTO getById(@PathVariable Long id) {
        Account account = getAccount.getById(id);
        return AccountExtensionDTO.toResponseDTO(account);
    }
}
