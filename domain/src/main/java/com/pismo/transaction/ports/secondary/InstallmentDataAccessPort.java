package com.pismo.transaction.ports.secondary;

import com.pismo.transaction.model.Installment;
import java.util.List;
import java.util.Optional;

public interface InstallmentDataAccessPort {
    Installment save(Installment installment);
    Optional<Installment> findById(Long id);
    List<Installment> findByTransactionId(Long transactionId);
}
