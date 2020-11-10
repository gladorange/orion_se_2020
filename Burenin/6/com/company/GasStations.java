package com.company;

import java.util.ArrayList;
import java.util.List;

public class GasStations {


    public static void main(String[] args) {
        List<Triple<String, GasolineType, Double>> list = new ArrayList<>();
        list.add(new Triple<>("Комсомольская пл., 3А", GasolineType.DT, 45.55));
        list.add(new Triple<>("Коминтерна, 17", GasolineType.AI92, 43.30));
        list.add(new Triple<>("Героя Попова, 58В", GasolineType.AI98, 49.99));
        list.add(new Triple<>("Ларина, 2", GasolineType.DT, 45.95));
        list.add(new Triple<>("Долгополова, 84А", GasolineType.AI98, 50.05));
        list.add(new Triple<>("Автозаводское, 2", GasolineType.AI95, 45.99));
        list.add(new Triple<>("Казанское шоссе, 7Б", GasolineType.AI92, 43.70));

    }

    public static void findBestPrice(List<Triple<String,GasolineType,Double>> list,GasolineType type) {
        if (list.isEmpty())
            throw new RuntimeException("Список заправок пуст");

        int bestGasStationPos = -1;
        Double minPrice = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Triple<String,GasolineType,Double> gasStation = list.get(i);
            if (gasStation.getSecond() == type) {
                if (gasStation.getThird() < minPrice) {
                    minPrice = gasStation.getThird();
                    bestGasStationPos = i;
                }
            }
        }
        if (bestGasStationPos != -1) {
            System.out.println(String.format("Бензоколонка с самой маленькой ценой на %s тип бензина находится по адресу - %s", type, list.get(bestGasStationPos).getFirst()));
        }
        else {
            System.out.println(String.format("Бензаколонок с %s типом бензина не обнаружено", type));
        }
    }
}
