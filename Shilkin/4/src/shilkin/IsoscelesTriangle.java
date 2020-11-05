package shilkin;

public class IsoscelesTriangle extends Figure{

    private final int height;
    private final int base;
    public IsoscelesTriangle(int x, int y, int height, int base) {
        super(x, y);
        this.height = height;
        this.base = base;
    }

    @Override
    protected int getSquare() {
        return (int) (0.5 * base * height);
    }

    @Override
    public String toString() {
        return "Равнобедренный треугольник, площадь = " + getSquare() + ", высота = " + height + ", основание = " + base;
    }
}
