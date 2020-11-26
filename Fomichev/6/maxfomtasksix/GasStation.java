package maxfomtasksix;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
    static String address;
    double price;
    public enum GasolineType {
        ДТ,
        АИ92,
        АИ95,
        АИ98
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "address='" + address + '\'' +
                ", price=" + price +
                '}';
    }

     static void findBestPrice(List<Triple<String, GasolineType, Double>> list, GasolineType type) {
        double min = Double.MAX_VALUE;
        for (Triple<String, GasolineType, Double> gasStation : list) {
            if (gasStation.getSecond() == type && gasStation.getThird() < min) {
                min = gasStation.getThird();
                address = gasStation.getFirst();
            }
        }

        System.out.printf("Заправка на %s имеет самую низкую цену на %s в размере %f рублей за литр\n", address, type.name(), min);
    }

    public static void main(String[] args) {
        List<Triple<String, GasolineType, Double>> list = new ArrayList<>();

        list.add(new Triple<>("Лукойл",GasolineType.ДТ, 25.5));
        list.add(new Triple<>("Лукойл",GasolineType.АИ92, 27.5));
        list.add(new Triple<>("Лукойл",GasolineType.АИ95, 29.5));
        list.add(new Triple<>("Лукойл",GasolineType.АИ98, 35.5));

        list.add(new Triple<>("Газпром",GasolineType.ДТ, 45.5));
        list.add(new Triple<>("Газпром",GasolineType.АИ92, 47.5));
        list.add(new Triple<>("Газпром",GasolineType.АИ95, 17.5));
        list.add(new Triple<>("Газпром",GasolineType.АИ98, 55.5));

        list.add(new Triple<>("Башнефть",GasolineType.ДТ, 55.5));
        list.add(new Triple<>("Башнефть",GasolineType.АИ92, 57.5));
        list.add(new Triple<>("Башнефть",GasolineType.АИ95, 59.5));
        list.add(new Triple<>("Башнефть",GasolineType.АИ98, 15.5));
        
        GasStation.findBestPrice(list, GasolineType.ДТ);
        GasStation.findBestPrice(list, GasolineType.АИ95);
        GasStation.findBestPrice(list, GasolineType.АИ98);
    }
}
