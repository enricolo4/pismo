package com.pismo.transaction.adapter;

import com.pismo.transaction.entity.InstallmentEntity;
import com.pismo.transaction.model.Installment;
import com.pismo.transaction.ports.secondary.InstallmentDataAccessPort;
import com.pismo.transaction.repository.InstallmentRepository;
import com.pismo.utils.extensions.InstallmentExtensions;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class InstallmentDataAccessAdapter implements InstallmentDataAccessPort {
    @Inject
    private InstallmentRepository installmentRepository;

    @Override
    public Installment save(Installment installment) {
        return installmentRepository.save(InstallmentExtensions.toEntity(installment)).toModel();
    }

    @Override
    public Optional<Installment> findById(Long id) {
        return installmentRepository.findById(id).map(InstallmentEntity::toModel);
    }

    @Override
    public List<Installment> findByTransactionId(Long transactionId) {
        return installmentRepository.findByTransactionId(transactionId)
            .stream()
            .map(InstallmentEntity::toModel)
            .toList();
    }
}
