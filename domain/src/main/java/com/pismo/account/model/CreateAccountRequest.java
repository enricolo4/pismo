package com.pismo.account.model;

import java.math.BigDecimal;

public record CreateAccountRequest(
    String documentNumber
) {
    public Account toModel() {
        return new Account(documentNumber, new Balance(null, BigDecimal.ZERO));
    }
}
