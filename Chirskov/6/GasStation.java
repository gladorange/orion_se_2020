import java.util.ArrayList;
import java.util.List;

public class GasStation {
    public enum GasolineType { ДТ, АИ92, АИ95, АИ98 }
    public static void main(String[] args) {
        List<Triple<String, GasolineType, Double>> gasStations = new ArrayList<>();
        gasStations.add(new Triple<>("г. Пушкин, улица Кукушкина, 123/4", GasolineType.АИ92, 32.3));
        gasStations.add(new Triple<>("г. Кукушкин, улица Коврова, 56/7", GasolineType.АИ95, 35.3));
        gasStations.add(new Triple<>("г. Ковров, улица Пушкина, 89", GasolineType.АИ98, 37.3));
        gasStations.add(new Triple<>("г. Москва, площадь Красная, 1", GasolineType.АИ98, 99.9));
        findBestPrice(gasStations, GasolineType.АИ98);
    }

    static void findBestPrice(List<Triple<String, GasolineType, Double>> gasStations, GasolineType type) {
        Pair<String, Double> bestPrice = new Pair<String, Double>("", (double)-1);
        for (Triple<String, GasolineType, Double> gasStation : gasStations) {
            if (gasStation.getSecond() == type) {
                double currentPrice = gasStation.getThird();
                if (bestPrice.getSecond() == -1) {
                    bestPrice.setFirst((String)gasStation.getFirst());
                    bestPrice.setSecond(currentPrice);
                } else {
                    if (bestPrice.getSecond() < currentPrice) {
                        bestPrice.setFirst((String)gasStation.getFirst());
                        bestPrice.setSecond(currentPrice);
                    }
                }
            }
        }
        System.out.println("Адрес бензоколонки с самой маленькой ценой на " + type + " - " + bestPrice.getFirst());
    }

}