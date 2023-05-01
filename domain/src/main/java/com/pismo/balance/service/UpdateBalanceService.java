package com.pismo.balance.service;

import com.pismo.balance.model.Balance;
import java.math.BigDecimal;

public interface UpdateBalanceService {
    Balance cashIn(Balance balance, BigDecimal amount);

    Balance cashOut(Balance balance, BigDecimal amount);

}
