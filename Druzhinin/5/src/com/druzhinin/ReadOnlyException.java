package com.druzhinin;

public class ReadOnlyException extends UnsupportedOperationException {

    public ReadOnlyException(String message) {
        super(message);
    }
}
