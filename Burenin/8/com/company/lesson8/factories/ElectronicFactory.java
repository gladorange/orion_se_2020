package com.company.lesson8.factories;

import com.company.lesson8.products.ElectronicItem;

import java.util.Collection;

public class ElectronicFactory {
    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> collection) {
        collection.add(new ElectronicItem.TV("Samsung"));
        collection.add(new ElectronicItem.Refrigerator("Atlant"));
        collection.add(new ElectronicItem.TV("LG"));
        collection.add(new ElectronicItem.Refrigerator("Bosch"));
        System.out.println("В магазин добавлена электроника: " + collection);
    }
}
