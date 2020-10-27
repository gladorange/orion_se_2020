package ru.localcat.task.b;

public class Raithing implements Comparable<Raithing>{
    private static double MIN = 0.0;
    private static double MAX = 5.0;
    private Double value;

    public Raithing(Double value) {
        if(value <= MAX && value >= MIN) {
            this.value = value;
        }
        else {
            throw new RuntimeException("Рэйтинг должен быть в ранге ["+ MIN +".."+ MAX +"]");
        }
    }

    public Double getValue() {
        return value;
    }

    @Override
    public int compareTo(Raithing raithing) {
        return this.value.compareTo(raithing.getValue());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
