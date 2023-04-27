package com.pismo.balance.repository;

import com.pismo.balance.entity.BalanceEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface BalanceRepository extends CrudRepository<BalanceEntity, Long> {
}
