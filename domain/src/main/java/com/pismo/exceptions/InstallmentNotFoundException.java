package com.pismo.exceptions;

public class InstallmentNotFoundException extends RuntimeException {
    public InstallmentNotFoundException(String message) {
        super(message);
    }
}
