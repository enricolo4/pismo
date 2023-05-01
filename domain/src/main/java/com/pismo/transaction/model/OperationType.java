package com.pismo.transaction.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum OperationType {
    BUY_THE_CASH(1L),
    INSTALLMENT_PURCHASE(2L),
    CASH_OUT(3L),
    PAYMENT(4L);

    public final Long operationTypeId;

    OperationType(Long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public static OperationType fromOperationTypeId(Long operationTypeId) {
        Optional<OperationType> operationTypeFound = Arrays.stream(OperationType.values())
            .filter(operationType -> Objects.equals(operationType.operationTypeId, operationTypeId))
            .findFirst();

        if(operationTypeFound.isPresent()) return operationTypeFound.get();

        throw new RuntimeException("Operation Type not exists=" + operationTypeId);
    }
}
