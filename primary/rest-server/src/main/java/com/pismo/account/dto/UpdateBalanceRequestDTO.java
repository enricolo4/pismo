package com.pismo.account.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UpdateBalanceRequestDTO(
    @NotNull
    @NotBlank
    BigDecimal value
) {}
