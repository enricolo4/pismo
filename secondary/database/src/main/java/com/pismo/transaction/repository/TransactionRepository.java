package com.pismo.transaction.repository;

import com.pismo.transaction.entity.TransactionEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long>  {
    List<TransactionEntity> findByAccountId(Long accountId);
}
