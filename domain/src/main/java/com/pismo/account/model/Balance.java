package com.pismo.account.model;

import java.math.BigDecimal;

public record Balance(
    Long id,
    BigDecimal value
) {}
