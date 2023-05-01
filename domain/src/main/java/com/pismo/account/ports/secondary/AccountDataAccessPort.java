package com.pismo.account.ports.secondary;

import com.pismo.account.model.Account;
import java.util.Optional;

public interface AccountDataAccessPort {
    Account save(Account account);
    Account update(Account account);

    Optional<Account> findById(Long id);

    boolean existsByDocumentNumber(String documentNumber);
}
