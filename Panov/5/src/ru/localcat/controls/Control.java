package ru.localcat.controls;

import java.awt.*;

public abstract class Control {
    protected int startPositionX;
    protected int startPositionY;
    protected int endPositionX;
    protected int endPositionY;
    protected String caption;
    protected boolean enabled;

    protected Rectangle thisRect = new Rectangle();
    protected Rectangle anotherRect = new Rectangle();

    public Control() {
    }

    public Control(String caption) {
        this.caption = caption;
    }

    public Control(int sX, int sY, int eX, int eY) {
        this.startPositionX = sX;
        this.startPositionY = sY;
        this.endPositionX = eX;
        this.endPositionY = eY;
    }

    /**
     * Проверяет наличие пересечение текущего элемента с фигурой заачйно 4мя координатыми
     *
     * @param sPX - координата начальной позиции по Х
     * @param sPY - координата конечной позиции по Х
     * @param ePX - координата начальной позиции по Y
     * @param ePY - координата конечной позиции по Y
     * @return
     */

    public boolean isIntersection(int sPX, int sPY, int ePX, int ePY) {
        thisRect.setRect(
                (double) startPositionX,
                (double) startPositionY,
                (double) endPositionX - (double) startPositionX,
                (double) endPositionY - (double) startPositionY
        );

        anotherRect.setRect(
                (double) sPX,
                (double) sPY,
                (double) ePX - (double) sPX,
                (double) ePY - (double) sPY
        );

        return thisRect.intersects(anotherRect);
    }

    /**
     * Проверяет наличие пересечение текущего элемента с другим контролом
     *
     * @param control - контрол для проверки на пересечение
     * @return
     */
    public boolean isIntersection(Control control) {
        return isIntersection(
                control.getStartPositionX(),
                control.getStartPositionY(),
                control.getEndPositionX(),
                control.getEndPositionY()
        );
    }

    public int getStartPositionX() {
        return startPositionX;
    }

    public void setStartPositionX(int startPositionX) {
        this.startPositionX = startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }

    public void setStartPositionY(int startPositionY) {
        this.startPositionY = startPositionY;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getEndPositionX() {
        return endPositionX;
    }

    public void setEndPositionX(int endPositionX) {
        this.endPositionX = endPositionX;
    }

    public int getEndPositionY() {
        return endPositionY;
    }

    public void setEndPositionY(int endPositionY) {
        this.endPositionY = endPositionY;
    }
}
