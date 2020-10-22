import com.druzhinin.accidentarenotrandom.SequentialRandom;

public class Main {

    public static void main(String[] args) {
        new SequentialRandom();
        new SequentialRandom();
        new SequentialRandom();
        SequentialRandom.resetRandom();
        new SequentialRandom();
        new SequentialRandom();
    }
}


