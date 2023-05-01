package com.pismo.exceptions;

public class AccountExistsException extends RuntimeException {
    public AccountExistsException(String message) {
        super(message);
    }
}
