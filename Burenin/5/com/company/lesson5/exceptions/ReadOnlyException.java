package com.company.lesson5.exceptions;

public class ReadOnlyException extends RuntimeException {

    public ReadOnlyException(String message) {
        super(message);
    }
}
