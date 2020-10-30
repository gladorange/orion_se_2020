import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Animal {

    private String name;
    private String type;
    Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + ' ' + name;
    }

    public static void main(String[] args) {
        Animal dog = new Animal("Шарик", "Собака");
        Animal cat = new Animal("Мурка", "Кошка");
        Animal bear = new Animal("Косолапый", "Медведь");
        List<Pair<Animal, String>> animals = new ArrayList<>();
        animals.add(new Pair<>(dog, "Кость"));
        animals.add(new Pair<>(cat, "Мышь"));
        animals.add(new Pair<>(bear, "Мёд"));
        feedAnimals(animals);
    }

    public static void feedAnimals(List<Pair<Animal, String>> animals) {
        int luckyNumber = ThreadLocalRandom.current().nextInt(0, animals.size());
        for (Pair<Animal, String> animal : animals) {
            System.out.println("Животное " + animal.getFirst() + " с радостью съедает " + animal.getSecond());
        }
        System.out.println("Счастливое животное " + animals.get(luckyNumber).getFirst()
                + " получает двойную порцию "+ animals.get(luckyNumber).getSecond());
    }
}
