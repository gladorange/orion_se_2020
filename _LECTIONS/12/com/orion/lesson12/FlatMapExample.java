package com.orion.lesson12;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapExample {



    static class Pair {
        Zoo zoo;
        Animal animal;

        public Pair(Zoo zoo, Animal animal) {
            this.zoo = zoo;
            this.animal = animal;
        }
    }

    static class Zoo {

        final String name;
        List<Animal> animals;

        Zoo(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Zoo{" +
                    "name='" + name + '\'' +
                    ", animals=" + animals +
                    '}';
        }
    }


    public static void main(String[] args) {


        List<Zoo> zoos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Zoo e = new Zoo("Зоопарк №" + i);
            e.animals = new ArrayList<>();

            for (int i1 = 0; i1 < 10; i1++) {
                e.animals.add(new Animal("Животное " + i + " " + i1));
            }
            zoos.add(e);
        }


        final List<String> namesInUpperCase = zoos.stream()
                .flatMap(zoo -> zoo.animals.stream())
                .map(animal -> animal.name)
                .map(String::toUpperCase)
                .collect(Collectors.toList());


        zoos.stream()
                .flatMap(zoo -> zoo.animals.stream().map(a -> new Pair(zoo, a)))
                .forEach(pa -> System.out.println(pa.zoo.name +" " + pa.animal.name));


        final Map<Zoo, List<Pair>> collect = zoos.stream()
                .flatMap(zoo -> zoo.animals.stream().map(a -> new Pair(zoo, a)))
                .collect(Collectors.groupingBy(pa -> pa.zoo));

        System.out.println(collect);

        final Map<String, Long> collect1 = zoos.stream()
                .flatMap(zoo -> zoo.animals.stream().map(a -> new Pair(zoo, a)))
                .collect(Collectors.groupingBy(pa -> pa.zoo.name, Collectors.counting()));


        System.out.println(collect1);
    }


}
