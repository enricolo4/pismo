package com.pismo.exceptions;

public class WrongTransactionAmountException extends RuntimeException {
    public WrongTransactionAmountException(String message) {
        super(message);
    }
}
