package com.pismo.account.ports.secondary;

import com.pismo.account.model.Account;
import java.util.Optional;

public interface AccountDataAccessPort {
    Account save(Account account);
    Account findById(Long id);
}
