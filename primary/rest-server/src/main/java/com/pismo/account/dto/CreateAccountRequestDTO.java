package com.pismo.account.dto;

import com.pismo.account.model.CreateAccountRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CreateAccountRequestDTO(
    @NotNull
    @NotBlank
    String documentNumber
) {
    public CreateAccountRequest toModel() {
        return new CreateAccountRequest(documentNumber);
    }
}
