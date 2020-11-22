package com.druzhinin;

import java.util.ArrayList;

public class ElectronicFabric {
    public void fillShopWithElectronicGoods(ArrayList<? super ElectronicItem> electronicShop) {
        electronicShop.add(new Refrigerator("Стинол", 12000.0, 2000.0, 1.1));
        electronicShop.add(new TV("Samsung", 52000.0, 210.0,75));
        electronicShop.add(new Refrigerator("LG", 22500.0, 1800.0, 1.55));
        electronicShop.add(new TV("LG", 49000.0, 235.5,85));
        electronicShop.add(new Refrigerator("Samsung", 25000.0, 1910.0, 1.4));
        electronicShop.add(new TV("Рубин", 23000.0, 350.0, 40));

        System.out.println("В магазин добавлена Электроника: ");
        System.out.println(electronicShop.toString());
    }
}
