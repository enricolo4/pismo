package com.pismo.account.utils;

import com.pismo.account.dto.AccountResponseDTO;
import com.pismo.account.model.Account;

public class AccountExtensionDTO {
    public static AccountResponseDTO toResponseDTO(Account account) {
        return new AccountResponseDTO(
            account.getId(),
            account.getDocumentNumber(),
            account.getBalance().getValue()
        );
    }
}
