package Taask_4;

class Circle extends Figure {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    String square() {
        return String.format("Circle - %s", Math.PI * radius * radius);
    }
}
