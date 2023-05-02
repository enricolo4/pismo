package com.pismo.transaction.usecase;

import com.pismo.exceptions.InstallmentNotFoundException;
import com.pismo.transaction.model.Installment;
import com.pismo.transaction.ports.primary.GetInstallmentPort;
import com.pismo.transaction.ports.secondary.InstallmentDataAccessPort;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class GetInstallmentUseCase implements GetInstallmentPort {
    @Inject
    InstallmentDataAccessPort installmentDataAccessPort;

    @Override
    public Installment getById(Long id) {
        Optional<Installment> installment = installmentDataAccessPort.findById(id);

        if(installment.isEmpty())
            throw new InstallmentNotFoundException("Installment not found=" + id);

        return installment.get();
    }

    @Override
    public List<Installment> getByTransactionId(Long transactionId) {
        List<Installment> installments = installmentDataAccessPort.findByTransactionId(transactionId);

        if(installments.isEmpty())
            throw new InstallmentNotFoundException("Installment not found for transaction=" + transactionId);

        return installments;
    }
}
