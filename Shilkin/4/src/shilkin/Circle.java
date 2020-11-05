package shilkin;

public class Circle extends Figure{
    private final int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    protected int getSquare() {
        return (int)(Math.PI * Math.pow(radius, 2));
    }

    @Override
    public String toString() {
        return "Круг, площадь = " + getSquare() + ", радиус = " + radius;
    }
}
