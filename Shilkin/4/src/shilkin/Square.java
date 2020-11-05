package shilkin;

public class Square extends Figure{
    private final int sideLength;

    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }
    @Override
    protected int getSquare() {
        return (sideLength * sideLength);
    }

    @Override
    public String toString() {
        return "Квадрат, площадь =  " + getSquare() + ", боковая сторона = " + sideLength;
    }
}
