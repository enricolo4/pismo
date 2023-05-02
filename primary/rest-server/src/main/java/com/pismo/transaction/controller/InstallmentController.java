package com.pismo.transaction.controller;

import com.pismo.transaction.dto.InstallmentResponseDTO;
import com.pismo.transaction.dto.InstallmentsResponseDTO;
import com.pismo.transaction.model.Installment;
import com.pismo.transaction.ports.primary.GetInstallmentPort;
import com.pismo.transaction.utils.InstallmentExtensionDTO;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;
import java.util.List;

@Controller("installments")
public class InstallmentController {
    @Inject
    private GetInstallmentPort getInstallmentPort;

    @Get("/{id}")
    InstallmentResponseDTO getById(@PathVariable Long id) {
        Installment installment = getInstallmentPort.getById(id);

        return InstallmentExtensionDTO.responseDTO(installment);
    }

    @Get("/transaction/{transactionId}")
    InstallmentsResponseDTO getByAccountId(@PathVariable Long transactionId) {
        List<Installment> installments = getInstallmentPort.getByTransactionId(transactionId);

        return InstallmentExtensionDTO.responseDTO(installments);
    }
}
