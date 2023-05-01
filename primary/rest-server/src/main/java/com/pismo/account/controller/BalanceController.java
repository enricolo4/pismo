package com.pismo.account.controller;

import com.pismo.account.dto.AccountResponseDTO;
import com.pismo.account.dto.UpdateBalanceRequestDTO;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import javax.validation.Valid;

@Controller("balance")
@Introspected(classes = UpdateBalanceRequestDTO.class)
public class BalanceController {
    @Post("/cash-in/account/{id}")
    AccountResponseDTO cashIn(
        @PathVariable Long id,
        @Body @Valid UpdateBalanceRequestDTO updateBalanceRequestDTO
    ) {

        return null;
    }
}
