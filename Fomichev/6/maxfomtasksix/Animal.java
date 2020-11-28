package maxfomtasksix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animal {
    String name;
    String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    private Object getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    static void feedAnimals(List<Pair<Animal, String>> list) {
        for (Pair<Animal, String> animal : list) {
            System.out.printf("Животное %s с радостью съедает %s\n", animal.getFirst().getName(), animal.getSecond());
        }

        int random = new Random().nextInt(list.size());
        System.out.printf("Счастливое животное %s получает двойную порцию %s\n",
                list.get(random).getFirst().getName(), list.get(random).getSecond());
    }

    public static void main(String[] args) {
        List<Pair<Animal, String>> animals = new ArrayList<>();

        animals.add(new Pair<>(new Animal("Бобик", "Собака"), "Кусок мяса"));
        animals.add(new Pair<>(new Animal("Мурка", "Кошка"), "Рыбу"));
        animals.add(new Pair<>(new Animal("Гарри", "Кролик"), "Морковку"));

        Animal.feedAnimals(animals);
    }
}
