package maxfomtaskfour.abstractuspupremus;

import java.util.Random;

public class Square extends Figure {
    public int length = new Random().nextInt(10) + 1;

    public int square() {
        return length * length;
    }

    @Override
    public String toString() {
        return "Квадрат - {" +
                "Площадь равна " + this.square() +
                "}";
    }
}
