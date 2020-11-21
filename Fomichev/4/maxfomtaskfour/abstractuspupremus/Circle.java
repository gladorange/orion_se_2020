package maxfomtaskfour.abstractuspupremus;

import java.util.Random;

public class Circle extends Figure {
    public int radius = new Random().nextInt(10) + 1;

    public int square() {
        return  (int) (Math.PI * radius * radius);
    }

    public Circle() {
    }



    @Override
    public String toString() {
        return "Круг - {" +
                "Площадь равна " + this.square() +
                "}";
    }
}
