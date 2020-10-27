package ru.localcat.task.b;

import ru.localcat.corteges.Triple;

import java.util.List;

public class GasolineHelper {

    public static void findBestPrice(List<Triple<String, GasolineType, Double>> gasolineList, GasolineType type) {
        int bestGasolineId = findBestPriceGetId(gasolineList, type);
        System.out.println("Самый дешевый бензин типа " + gasolineList.get(bestGasolineId).getSecond() +
                " тут " + gasolineList.get(bestGasolineId).getFirst());
    }

    public static int findBestPriceGetId(List<Triple<String, GasolineType, Double>> gasolineList, GasolineType type) {
        int bestPositon = 0;
        int counter = 0;
        double bestPrice = Double.MAX_VALUE;
        if(gasolineList.size() > 0) {
            for (Triple<String, GasolineType, Double> stringGasolineTypeDoubleTriple : gasolineList) {
                if (stringGasolineTypeDoubleTriple.getSecond() == type) {
                    if(stringGasolineTypeDoubleTriple.getThird() <= bestPrice) {
                        bestPrice = stringGasolineTypeDoubleTriple.getThird();
                        bestPositon = counter;
                    }
                }
                counter++;
            }
        } else {
            throw new RuntimeException("Список колонок не должен быть пуст!");
        }
        return bestPositon;
    }
}
