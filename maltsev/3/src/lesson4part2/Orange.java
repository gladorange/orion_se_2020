package lesson4part2;

import java.util.Random;

public class Orange extends Fruit{

    private int peelThickness;

    public Orange() {
        this.peelThickness = new Random().nextInt(21);
    }

    @Override
    public String toString()
    {
        return this.peelThickness + " апельсин";
    }

}
