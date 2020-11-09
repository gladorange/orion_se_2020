package com.druzhinin;

public abstract class Rectangle {
    protected Point point;
    protected int width;
    protected int height;

    protected String caption;

    protected boolean active;

    public Rectangle() {
        point = new Point();
    }

    public Rectangle(Point point, int width, int height, String caption, boolean active) {
        this.point = point;
        this.width = Math.abs(width);
        this.height = Math.abs(height);
        this.caption = caption;
        this.active = active;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isActive() {
        return active;
    }

    public void setState(boolean active) {
        this.active = active;
    }

    public int getX() {
        return point.x;
    }

    public int getY () {
        return point.y;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "point=" + point +
                ", width=" + width +
                ", height=" + height +
                ", caption='" + caption + '\'' +
                ", active=" + active +
                '}';
    }
}
