package shilkin;

public class Apple extends Fruit{
    private final String color;

    public Apple(int weight, String color) {
        super(weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Яблоко, " + "Цвет - " + color + ", вес = " + weight;
    }
}
