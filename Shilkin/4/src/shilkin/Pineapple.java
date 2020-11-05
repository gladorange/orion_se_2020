package shilkin;

public class Pineapple extends Fruit{

    private final int tailHeight;

    public Pineapple(int weight, int tailHeight) {
        super(weight);
        this.tailHeight = tailHeight;
    }

    @Override
    public String toString() {
        return "Ананас, " + "высота хвоста = " + tailHeight + ", вес = " + weight;
    }
}
