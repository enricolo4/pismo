package com.pismo.transaction.utils;

import com.pismo.transaction.dto.InstallmentResponseDTO;
import com.pismo.transaction.dto.InstallmentsResponseDTO;
import com.pismo.transaction.dto.TransactionResponseDTO;
import com.pismo.transaction.dto.TransactionsResponseDTO;
import com.pismo.transaction.model.Installment;
import com.pismo.transaction.model.Transaction;
import java.util.List;

public final class InstallmentExtensionDTO {
    public static InstallmentResponseDTO responseDTO(Installment installment) {
        return new InstallmentResponseDTO(
            installment.getId(),
            installment.getAmount(),
            installment.getTransaction().getId(),
            installment.getInstallment(),
            installment.getInstallmentDue().toString()
        );
    }

    public static InstallmentsResponseDTO responseDTO(List<Installment> installments) {
        List<InstallmentResponseDTO> installmentsResponseDTO = installments
            .stream()
            .map(InstallmentExtensionDTO::responseDTO)
            .toList();

        return new InstallmentsResponseDTO(installmentsResponseDTO);
    }
}
