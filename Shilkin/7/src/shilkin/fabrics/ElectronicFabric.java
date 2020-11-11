package shilkin.fabrics;

import shilkin.items.ElectronicItem;
import shilkin.products.Refrigerator;
import shilkin.products.TV;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ElectronicFabric {

    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> items) {
        List<ElectronicItem> addedElectronicItems = new ArrayList<>();
        addedElectronicItems.add(new Refrigerator("ПЗ-300", 13000, 100, 20));
        addedElectronicItems.add(new TV("Panasonic 22 pro", 30000, 50, 50));
        addedElectronicItems.add(new TV("LG 10 lite", 15000, 35, 40));
        addedElectronicItems.add(new Refrigerator("Ice 102", 20000, 150, 60));
        items.addAll(addedElectronicItems);
        System.out.println("В магазин добавлена электроника:");
        for (ElectronicItem addedElectronicItem : addedElectronicItems) {
            System.out.println(addedElectronicItem.toString());
        }
    }
}
