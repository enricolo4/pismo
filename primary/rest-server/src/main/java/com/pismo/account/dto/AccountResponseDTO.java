package com.pismo.account.dto;

import java.math.BigDecimal;

public record AccountResponseDTO(
    Long id,
    String documentNumber,
    BigDecimal balance
) {}
