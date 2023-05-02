package com.pismo.utils.extensions;

import com.pismo.transaction.entity.InstallmentEntity;
import com.pismo.transaction.model.Installment;

public final class InstallmentExtensions {
    public static InstallmentEntity toEntity(Installment installment) {
        return new InstallmentEntity(
            installment.getId(),
            installment.getAmount(),
            installment.getInstallment(),
            installment.getInstallmentDue(),
            TransactionExtensions.toEntity(installment.getTransaction())
        );
    }
}
