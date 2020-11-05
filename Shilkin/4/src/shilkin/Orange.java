package shilkin;

public class Orange extends Fruit{

    private final int peelThickness;

    public Orange(int weight, int peelThickness) {
        super(weight);
        this.peelThickness = peelThickness;
    }

    @Override
    public String toString() {
        return "Апельсин, " + "высота хвоста = " + peelThickness + ", вес = " + weight;
    }
}
