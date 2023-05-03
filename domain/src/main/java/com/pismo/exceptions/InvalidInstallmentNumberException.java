package com.pismo.exceptions;

public class InvalidInstallmentNumberException extends RuntimeException {
    public InvalidInstallmentNumberException(String message) {
        super(message);
    }
}
