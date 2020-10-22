package ru.localcat.exceptions;

public class ReadOnlyException extends RuntimeException{

    public ReadOnlyException(String message) {
        super(message);
    }
}
