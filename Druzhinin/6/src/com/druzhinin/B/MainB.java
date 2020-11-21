package com.druzhinin.B;

import com.druzhinin.Pair;
import com.druzhinin.Triple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainB {
    public static void main(String[] args) {
        List<Triple<String, GasolineType, Double>> fillingStations = new ArrayList<>();

        // Лукойл
        fillingStations.add(new Triple<>("Ванеева, 110В", GasolineType.OCTANE92, 43.90));
        fillingStations.add(new Triple<>("Ванеева, 110В", GasolineType.OCTANE95, 47.50));
        fillingStations.add(new Triple<>("Ванеева, 110В", GasolineType.OCTANE98, 52.25));
        fillingStations.add(new Triple<>("Ванеева, 110В", GasolineType.DIESEL, 47.21));

        // Терминал
        fillingStations.add(new Triple<>("Ванеева, 108В", GasolineType.OCTANE92, 42.90));
        fillingStations.add(new Triple<>("Ванеева, 108В", GasolineType.OCTANE95, 46.30));
        fillingStations.add(new Triple<>("Ванеева, 108В", GasolineType.DIESEL, 45.90));

        // Газпромнефть
        fillingStations.add(new Triple<>("Академика Сахарова, 8", GasolineType.OCTANE92, 43.30));
        fillingStations.add(new Triple<>("Академика Сахарова, 8", GasolineType.OCTANE95, 46.30));
        fillingStations.add(new Triple<>("Академика Сахарова, 8", GasolineType.OCTANE98, 50.85));
        fillingStations.add(new Triple<>("Академика Сахарова, 8", GasolineType.DIESEL, 46.05));

        findBestPrice(fillingStations, GasolineType.DIESEL);
        findBestPrice(fillingStations, GasolineType.OCTANE92);
        findBestPrice(fillingStations, GasolineType.OCTANE95);
        findBestPrice(fillingStations, GasolineType.OCTANE98);

        System.out.println("\n#######---------Отсортировано по количеству оценок---------#######");

        List<Triple<String, Double, Double>> applications = new ArrayList<>();
        applications.add(new Triple<>("Тетрис", 100.00, 4.35));
        applications.add(new Triple<>("Текстовый редактор", 51.00, 3.88));
        applications.add(new Triple<>("Видео редактор", 114.00, 4.55));
        applications.add(new Triple<>("Повареная книга", 11.00, 3.34));
        applications.add(new Triple<>("Знакомства в интернете", 909.00, 4.11));

        sortByNumberOfRating(applications);

        System.out.println("\n#######---------Лучшая оценка---------#######");
        bestRating(applications);

        System.out.println("\n#######---------Худшая оценка---------#######");
        worstRating(applications);
    }

    public static void findBestPrice(List<Triple<String, GasolineType, Double>> list, GasolineType type ) {
        List<Pair<String, Double>> sorted = new ArrayList<>();

        for (Triple triple : list) {
            if (triple.getSecond() == type) {
                String address = (String) triple.getFirst();
                Double price = (Double) triple.getThird();
                sorted.add(new Pair<String, Double>(address, price));
            }
        }

        Comparator<Pair> compareByPrice = new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                Double firstPrice = (Double) pair.getSecond();
                Double secondPrice = (Double) t1.getSecond();
                return firstPrice.compareTo(secondPrice);
            }
        };

        Pair<String, Double> minStation = Collections.min(sorted, compareByPrice);
        String minAddress = minStation.getFirst();
        Double minPrice = minStation.getSecond();

        System.out.printf("По адресу %s цена %s топлива марки %s\n", minAddress, minPrice, type);
    }

    public static void sortByNumberOfRating(List<Triple<String, Double, Double>> list) {
        Comparator<Triple> compareByNumberOfRating = compareByNumberOfRating();

        list.sort(compareByNumberOfRating);

        for (Triple<String, Double, Double> application : list) {
            String name = application.getFirst();
            Double numberOfRating = application.getSecond();
            Double averageRating = application.getThird();

            System.out.printf("Приложение %s количство оценок %s средний рейтинг %S\n", name, numberOfRating, averageRating);
        }
    }

    public static void bestRating(List<Triple<String, Double, Double>> list) {
        Comparator<Triple> bestComparator = compareByRating();

        Triple<String, Double, Double> best = Collections.max(list, bestComparator);
        String name = best.getFirst();
        Double numberOfRating = best.getSecond();
        Double averageRating = best.getThird();
        System.out.printf("Лучшее приложение %s по рейтингу %S\n", name, averageRating);
    }

    public static void worstRating(List<Triple<String, Double, Double>> list) {
        Comparator<Triple> worstComparator = compareByRating();

        Triple<String, Double, Double> best = Collections.min(list, worstComparator);
        String name = best.getFirst();
        Double numberOfRating = best.getSecond();
        Double averageRating = best.getThird();
        System.out.printf("Худшее приложение %s по рейтингу %S\n", name, averageRating);
    }

    public static Comparator<Triple> compareByNumberOfRating() {
        Comparator<Triple> compareByNumberOfRating = new Comparator<Triple>() {
            @Override
            public int compare(Triple triple, Triple t1) {
                Double rating1 = (Double) triple.getSecond();
                Double rating2 = (Double) t1.getSecond();
                return rating1.compareTo(rating2);
            }
        };

        return  compareByNumberOfRating;
    }

    public static Comparator<Triple> compareByRating() {
        Comparator<Triple> compareByNumberOfRating = new Comparator<Triple>() {
            @Override
            public int compare(Triple triple, Triple t1) {
                Double rating1 = (Double) triple.getThird();
                Double rating2 = (Double) t1.getThird();
                return rating1.compareTo(rating2);
            }
        };

        return  compareByNumberOfRating;
    }
}
