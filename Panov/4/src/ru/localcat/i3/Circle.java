package ru.localcat.i3;

public class Circle extends Figure{
    private static final int RADIUS_MIN = 1;
    private static final int RADIUS_MAX = 10;

    private int radius = RADIUS_MIN;

    public Circle()
    {
        this.figureName = "Круг";
    }

    @Override
    public int square() {
        return (int) Math.PI*radius*radius;
    }

    public Circle setRadius(int radius) throws Exception {
        this.radius = validateRange(radius, RADIUS_MIN, RADIUS_MAX);
        return this;
    }
}
