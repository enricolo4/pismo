package com.pismo.transaction.model;

import com.pismo.account.model.Account;
import java.math.BigDecimal;

public record Transaction(
    Long id,
    Long operationTypeId,
    BigDecimal amount,
    Account account
) {}
