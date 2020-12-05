package maxfomtaskfive;

import java.util.Random;

public class Rectangle {
    int x, y;
    int height, length;
    String caption;
    boolean isOn;
    Random r = new Random();

    public Rectangle(int x, int y, String caption) {
        this.x = x;
        this.y = y;
        height = 30;
        length = 30;
        this.caption = caption;
        isOn = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
