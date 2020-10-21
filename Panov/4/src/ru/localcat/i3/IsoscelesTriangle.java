package ru.localcat.i3;

public class IsoscelesTriangle extends Figure{
    private static final int BASE_MIN = 0;
    private static final int BASE_MAX = 10;

    private static final int HEIGHT_MIN = 0;
    private static final int HEIGHT_MAX = 10;

    private int height = HEIGHT_MIN;
    private int base = BASE_MIN;

    public IsoscelesTriangle() {
        this.figureName = "Равнобедренный треугольник";
    }

    @Override
    public int square() {
        return (int) (height*base)/2;
    }

    public IsoscelesTriangle setHeight(int height) throws Exception {
        this.height = validateRange(height, HEIGHT_MIN, HEIGHT_MAX);
        return this;
    }

    public IsoscelesTriangle setBase(int base) throws Exception {
        this.base = validateRange(base, BASE_MIN, BASE_MAX);
        return this;
    }
}
