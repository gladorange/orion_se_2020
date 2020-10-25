package ru.localcat;

import ru.localcat.controls.Control;
import ru.localcat.exceptions.ElementsOverlapException;
import ru.localcat.exceptions.OutOfCanvasException;

import java.util.ArrayList;

public class UI {
    private ArrayList<Control> uiItems = new ArrayList<>();
    private int sizeX;
    private int sizeY;

    public ArrayList<Control> getAllElements() {
        return uiItems;
    }

    public void addElement(Control control) {
        if(control.getEndPositionX() > sizeX || control.getEndPositionY() > sizeY) {
            throw new OutOfCanvasException(control + " не может полностью поместиться на канве");
        }
        for (Control uiItem : uiItems) {
            if(uiItem.isIntersection(control)) {
                throw new ElementsOverlapException("Обнаружено пересечение с контролом " + uiItem.getCaption());
            }
        }
        uiItems.add(control);
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
}
