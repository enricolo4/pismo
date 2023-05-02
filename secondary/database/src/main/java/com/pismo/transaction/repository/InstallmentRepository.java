package com.pismo.transaction.repository;

import com.pismo.transaction.entity.InstallmentEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;

@Repository
public interface InstallmentRepository extends CrudRepository<InstallmentEntity, Long> {
    List<InstallmentEntity> findByTransactionId(Long transactionId);
}
