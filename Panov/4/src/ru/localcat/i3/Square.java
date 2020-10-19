package ru.localcat.i3;

public class Square extends Figure{
    private static final int SIDE_MIN = 1;
    private static final int SIDE_MAX = 10;

    private int width = SIDE_MIN;
    private int height = SIDE_MIN;

    public Square() {
        this.figureName = "Квадрат";
    }

    @Override
    public int square() {
        return width*height;
    }

    public Square setWidth(int width) throws Exception {
        this.width = validateRange(width, SIDE_MIN, SIDE_MAX);
        return this;
    }

    public Square setHeight(int height) throws Exception {
        this.height = validateRange(height, SIDE_MIN, SIDE_MAX);
        return this;
    }
}
