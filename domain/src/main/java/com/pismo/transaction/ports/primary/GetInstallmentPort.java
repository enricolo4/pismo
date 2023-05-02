package com.pismo.transaction.ports.primary;

import com.pismo.transaction.model.Installment;
import java.util.List;

public interface GetInstallmentPort {
    Installment getById(Long id);
    List<Installment> getByTransactionId(Long transactionId);
}
