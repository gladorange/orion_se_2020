package shilkin;

public class Fruit {

    protected final int weight;

    public Fruit(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Фрукт, " + "у которого высота = " + weight;
    }
}
