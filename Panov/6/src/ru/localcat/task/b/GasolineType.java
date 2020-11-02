package ru.localcat.task.b;

public enum GasolineType {
    DT("ДТ"),
    AI92("АИ-92"),
    AI95("АИ-95"),
    AI98("АИ-98");

    private String caption;

    GasolineType(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return caption;
    }
}
