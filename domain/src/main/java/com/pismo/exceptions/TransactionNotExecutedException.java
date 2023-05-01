package com.pismo.exceptions;

public class TransactionNotExecutedException extends RuntimeException {
    public TransactionNotExecutedException(String message) {
        super(message);
    }
}
