package com.company.lesson5.controls;

import com.company.lesson5.controls.interfaces.ButtonClickCallback;
import com.company.lesson5.controls.interfaces.Clickable;
import com.company.lesson5.exceptions.ReadOnlyException;

public class Button extends Rectangle implements Clickable {
    ButtonClickCallback callback;

    public Button(String caption) {
        super(caption);
        this.callback = new ButtonClickCallback() {
            @Override
            public void onClicked() {
                System.out.println(String.format("Нажата кнопка в <%s,%s>", x, y));
            }
        };
    }

    public Button(String caption, ButtonClickCallback callback) {
        super(caption);
        this.callback = callback;
    }
    @Override
    public void click() {
        if (!active) {
            throw new ReadOnlyException("Элемент выключен");
        }
        callback.onClicked();
    }

    @Override
    public String toString() {
        return String.format("Кнопка в координатах <%s,%s>, ширина <%s>, высота <%s>, Название: <%s>", x, y, width, height, caption);
    }
}
