package Taask_4;

public class Apple extends Fruit {
    public Colors color;

    public Apple() {
        super();
        this.color = Colors.getRandom();
    }

    public Apple(int weight, Colors color) {
        super(weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight='" + weight + '\'' +
                "color='" + color + '\'' +
                '}';
    }
}
