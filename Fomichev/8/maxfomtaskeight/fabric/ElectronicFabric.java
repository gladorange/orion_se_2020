package maxfomtaskeight.fabric;

import maxfomtaskeight.ElectronicItem;
import maxfomtaskeight.Refrigerator;
import maxfomtaskeight.ShopItem;
import maxfomtaskeight.TV;

import java.util.Collection;
import java.util.Random;

public class ElectronicFabric {

    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shop) {
        StringBuilder electronicList = new StringBuilder();

        for (int i = 0; i < new Random().nextInt(3) + 2; i++) {
            shop.add(addElectronic(electronicList));
        }

        System.out.println("В магазин добавлена электроника: " + electronicList.toString());
    }

        private static ElectronicItem addElectronic(StringBuilder electronicList) {
            switch (new Random().nextInt(3)) {
                case (0):
                    electronicList.append("Bosch, ");
                    return new Refrigerator("Bosch", 15_000, 150, 300);
                case (1):
                    electronicList.append("DEXP, ");
                    return new TV("DEXP", 20_000, 50, 100);
                case (2):
                    electronicList.append("Philips, ");
                    return new TV("Philips", 15_000, 40, 90);
                default:
                    return null;
            }


        }
}
