package Taask_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Fruit {
    final int MIN_WEIGHT = 1;
    final int MAX_WEIGHT = 10;
    public int weight;

    public Fruit() {
        this.weight = ThreadLocalRandom.current().nextInt(MIN_WEIGHT, MAX_WEIGHT);
    }

    public Fruit(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight='" + weight + '\'' +
                '}';
    }

    public enum Colors {
        Orange("Orange"),
        Green("Green"),
        Red("Red");

        private final String color;

        Colors(String color) {
            this.color = color;
        }

        public static Colors getRandom() {
            return Colors.values()[ThreadLocalRandom.current().nextInt(Colors.values().length)];
        }

        @Override
        public String toString() {
            return this.color;
        }
    }
}
