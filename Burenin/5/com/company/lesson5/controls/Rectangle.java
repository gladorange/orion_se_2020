package com.company.lesson5.controls;

public abstract class Rectangle {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean active;
    protected String caption;

    Rectangle(String caption) {
        this.caption = caption;
        this.active = true;
    }

    public String getCaption() {
        return caption;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setProperties(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isIntersects(Rectangle r) {
        return x < r.x + r.width
                && x + width > r.x
                && y < r.y + r.height
                && y + height > r.y;
    }
}
