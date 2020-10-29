package Fruit;
import java.util.Random;

public class Pineapple extends Fruit {
    private final int tailTall;

    private static final Random RANDOM = new Random();

    public Pineapple(){
        final int MAX_TAIL_TALL = 10;
        this.tailTall = RANDOM.nextInt(MAX_TAIL_TALL);
    }

    @Override
    public String toString() {
        return "Это ананас с высотой хвоста "+tailTall+" и весом "+super.fruitWeight;
    }
}
