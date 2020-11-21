package maxfomtaskfour.abstractuspupremus;

import java.util.Random;

public class IsoscelesTriangle extends Figure {
    public int height = new Random().nextInt(10) + 1;
    public int floot = new Random().nextInt(10) + 1;

    public int square() {
        return height * floot;
    }

    @Override
    public String toString() {
        return "Треугольник - {" +
                "Площадь равна " + this.square() +
                "}";
    }
}
