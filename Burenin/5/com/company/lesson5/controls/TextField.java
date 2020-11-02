package com.company.lesson5.controls;

import com.company.lesson5.exceptions.ReadOnlyException;

public class TextField extends Rectangle {
    String text;

    public TextField(String caption, String text) {
        super(caption);
        this.text = text;
    }

    public void setText(String text) {
        if (!active) {
            throw new ReadOnlyException("Элемент выключен");
        }
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("Текстовое поле в координатах <%s,%s>, ширина <%s>, высота <%s>, Название: <%s>",
                x, y, width, height, caption);
    }
}
