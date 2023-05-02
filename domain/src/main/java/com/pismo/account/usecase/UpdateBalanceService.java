package com.pismo.account.usecase;

import com.pismo.account.model.Account;
import java.math.BigDecimal;

public interface UpdateBalanceService {
    Account cashIn(Account account, BigDecimal amount);

    Account cashOut(Account account, BigDecimal amount);

}
