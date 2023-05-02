package com.pismo.transaction.dto;

import java.util.List;

public record InstallmentsResponseDTO(
    List<InstallmentResponseDTO> installments
) {}
