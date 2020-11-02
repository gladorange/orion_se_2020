package com.company.lesson5;

import com.company.lesson5.controls.Rectangle;
import com.company.lesson5.exceptions.ElementsOverlapException;

import java.util.ArrayList;
import java.util.List;

public class UI {
    List<Rectangle> allElements = new ArrayList<>();
    int width = 100;
    int height = 100;

    public List<Rectangle> getAllElements() {
        return allElements;
    }

    void addElement(Rectangle r) {
        if (r.getX() + r.getWidth() > width || r.getY() + r.getHeight() > height) {
            throw new ElementsOverlapException(String.format("Элемент %s <%s,%s> выходит за границы UI сцены", r.getCaption(), r.getX(), r.getY()));
        }
        for (Rectangle e : allElements) {
            if (e.isIntersects(r)) {
                throw new ElementsOverlapException(String.format("Элемент %s <%s,%s> пересекается с элементом %s <%s,%s>",
                        r.getCaption(), r.getX(), r.getY(), e.getCaption(), e.getX(), e.getY()));
            }
        }
        allElements.add(r);
    }
}
