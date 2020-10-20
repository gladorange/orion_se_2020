package com.orion.lesson5;

public class OrionException extends Exception {

    private final CriticalLevel level;

    enum CriticalLevel {
        ERROR, IGNORE
    }

    public OrionException(String message, CriticalLevel level) {
        super(message);
        this.level = level;
    }

    public CriticalLevel getLevel() {
        return level;
    }
}
