package com.pismo.account.repository;

import com.pismo.account.entity.AccountEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    AccountEntity findByDocumentNumber(String documentNumber);

    boolean existsByDocumentNumber(String documentNumber);
}
