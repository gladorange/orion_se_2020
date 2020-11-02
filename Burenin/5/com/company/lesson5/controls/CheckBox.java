package com.company.lesson5.controls;

import com.company.lesson5.controls.interfaces.Clickable;
import com.company.lesson5.exceptions.ReadOnlyException;

import java.util.concurrent.ThreadLocalRandom;

public class CheckBox extends Rectangle implements Clickable {
    boolean checked;

    public CheckBox(String caption) {
        super(caption);
        this.checked = ThreadLocalRandom.current().nextBoolean();
    }

    @Override
    public void click() {
        if (!active) {
            throw new ReadOnlyException("Элемент выключен");
        }
        checked = !checked;
        System.out.println("Новое состояние галки " + checked);
    }

    @Override
    public String toString() {
        return String.format("Галка в координатах <%s,%s>, ширина <%s>, высота <%s>, Название: <%s>", x, y, width, height, caption);
    }
}
