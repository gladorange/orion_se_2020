package com.company;

public enum GasolineType {
    DT("ДТ"),
    AI92("АИ-92"),
    AI95("АИ-95"),
    AI98("АИ-98");

    private String title;

    GasolineType(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }
}
