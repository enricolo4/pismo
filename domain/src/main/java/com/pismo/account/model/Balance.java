package com.pismo.account.model;

import java.math.BigDecimal;

public class Balance {
    private Long id;
    private BigDecimal value;

    public Balance(Long id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Balance cashOut(BigDecimal amount) {
        setValue(this.value.subtract(amount));
        return this;
    }

    public Balance cashIn(BigDecimal amount) {
        setValue(this.value.add(amount));
        return this;
    }
}
