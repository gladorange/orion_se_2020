package Taask_4;

class Square extends Figure {
    int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    String square() {
        return String.format("Square - %s", Math.pow(side, 2));
    }
}
