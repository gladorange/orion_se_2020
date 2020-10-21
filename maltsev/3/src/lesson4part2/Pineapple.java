package lesson4part2;

import java.util.Random;

public class Pineapple extends Fruit {

    int tailHeight;

    public Pineapple() {

        tailHeight = 5 + new Random().nextInt(16);

    }

    @Override
    public String toString()
    {
        return tailHeight + " pineapple";
    }


}
