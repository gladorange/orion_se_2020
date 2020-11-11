package shilkin;

import shilkin.tuples.Pair;
import shilkin.tuples.Triple;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Pair<Animal, String> cow = new Pair<>(new Animal("корова", "home"), "трава");
        Pair<Animal, String> wolf = new Pair<>(new Animal("волк", "wild"), "мясо");
        Pair<Animal, String> cat = new Pair<>(new Animal("кошка", "home"), "молоко");
        Pair<Animal, String> dog = new Pair<>(new Animal("свинья", "home"), "каша");
        Pair<Animal, String> pig = new Pair<>(new Animal("белка", "wild"), "орех");

        List<Pair<Animal, String>> animalsList = new ArrayList<>();
        animalsList.add(cow);
        animalsList.add(wolf);
        animalsList.add(cat);
        animalsList.add(dog);
        animalsList.add(pig);

        feedAnimals(animalsList);
        System.out.println();

        Triple<String, GasolineType, Double> proto = new Triple<>("ул. Секретная, 35", GasolineType.AI95, 34.60);
        Triple<String, GasolineType, Double> lukoil = new Triple<>("ул. Надежды Сусловой, 21", GasolineType.AI95, 47.50);
        Triple<String, GasolineType, Double> terminal = new Triple<>("ул. Родионова, 198, корп. 1", GasolineType.AI92, 42.70);
        Triple<String, GasolineType, Double> opti = new Triple<>("ул. Долгополова, 84А", GasolineType.AI92, 42.89);
        Triple<String, GasolineType, Double> roronoa = new Triple<>("ул. Мечника, 4", GasolineType.AI98, 47.10);
        Triple<String, GasolineType, Double> marko = new Triple<>("ул. надежная, 10", GasolineType.DT, 42.89);
        Triple<String, GasolineType, Double> tohsaka = new Triple<>("ул. Добрая, 12", GasolineType.AI95, 44.60);
        Triple<String, GasolineType, Double> shiro = new Triple<>("ул. Честная, 31А", GasolineType.DT, 45.15);
        Triple<String, GasolineType, Double> gasgasgas = new Triple<>("ул. Гоночная, 16А", GasolineType.AI98, 48.12);
        List<Triple<String, GasolineType, Double>> gasStationsList = new ArrayList<>();

        gasStationsList.add(marko);
        gasStationsList.add(lukoil);
        gasStationsList.add(terminal);
        gasStationsList.add(opti);
        gasStationsList.add(roronoa);
        gasStationsList.add(proto);
        gasStationsList.add(tohsaka);
        gasStationsList.add(shiro);
        gasStationsList.add(gasgasgas);

        findBestPrice(gasStationsList, GasolineType.AI95);
        System.out.println();
        findBestPrice(gasStationsList, GasolineType.FF);
        System.out.println();

        Triple<String, Integer, Double> zoom = new Triple<String, Integer, Double>("ZOOM", 1000000, 3.4);
        Triple<String, Integer, Double> tikTok = new Triple<String, Integer, Double>("TikTok", 27000000, 4.5);
        Triple<String, Integer, Double> aliexpress = new Triple<String, Integer, Double>("AliExpress", 10000000, 4.5);
        Triple<String, Integer, Double> wildberries = new Triple<String, Integer, Double>("Wildberries", 322000, 4.2);
        Triple<String, Integer, Double> ozon = new Triple<String, Integer, Double>("OZON", 397000, 4.8);
        Triple<String, Integer, Double> getcontact = new Triple<String, Integer, Double>("getcontact", 746000, 4.4);
        Triple<String, Integer, Double> discord = new Triple<String, Integer, Double>("Discord", 2000000, 4.7);
        List<Triple<String, Integer, Double>> appsList = new ArrayList<>();
        appsList.add(zoom);
        appsList.add(tikTok);
        appsList.add(aliexpress);
        appsList.add(wildberries);
        appsList.add(ozon);
        appsList.add(getcontact);
        appsList.add(discord);

        getAppsInfo(appsList);
    }

    static void feedAnimals(List<Pair<Animal, String>> list) {
        Random random = new Random();
        int randomAnimal = random.nextInt(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (i == randomAnimal) {
                System.out.println(("Счастливое животное " + list.get(i).getFirst().getName() + " получает двоиную порцию " + list.get(i).getSecond()));
            } else {
                System.out.println("Животное " + list.get(i).getFirst().getName() + " с радостью съедает " + list.get(i).getSecond());
            }
        }
    }

    static void findBestPrice(List<Triple<String, GasolineType, Double>> list, GasolineType type) {
        Triple<String, GasolineType, Double> min = new Triple<>("temp",type,999.99);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getSecond() == type) {
                if (list.get(i).getThird() < min.getThird()) {
                    min = list.get(i);
                }
            }
        }
        if (min.getFirst().equals("temp")){
            System.out.println("Такого типа топлива нет в списке бензоколонок");
        }else {
            System.out.println("Адрес бензоколонки с самой маленькой ценой " + min.getFirst());
        }
    }

    static void getAppsInfo(List<Triple<String, Integer, Double>> list) {

        System.out.println("Все приложения, отсортированные по количеству оценок:");
        list.sort((o1, o2) -> o1.getSecond().compareTo(o2.getSecond()));
        for (Triple<String, Integer, Double> app : list) {
            System.out.println(app.getFirst());
        }
        System.out.println();

        Triple<String, Integer, Double> min = list.get(0);
        Triple<String, Integer, Double> max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getThird() > max.getThird()) {
                max = list.get(i);
            } else if (list.get(i).getThird() < min.getThird()) {
                min = list.get(i);
            }
        }
        System.out.println("Приложение с самым лучшим рейтингом " + max.getThird());
        System.out.println("Приложение с самым худшим рейтингом " + min.getThird());
    }
}
