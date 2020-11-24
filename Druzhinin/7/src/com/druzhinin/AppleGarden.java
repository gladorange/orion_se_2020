package com.druzhinin;

import java.util.ArrayList;

public class AppleGarden {
    public void fillShopWithApples(ArrayList<? super Apple> shop) {
        shop.add(new Apple("Наливное", 60.0, 55, 25, Colors.YELLOW));
        shop.add(new Apple("Наливное", 60.0, 55, 25, Colors.YELLOW));
        shop.add(new Apple("Наливное", 60.0, 55, 25, Colors.YELLOW));
        shop.add(new Apple("Наливное", 60.0, 55, 25, Colors.YELLOW));
        shop.add(new Apple("Наливное", 60.0, 55, 25, Colors.YELLOW));
        shop.add(new Apple("Семеренко", 120.0, 44, 50, Colors.GREEN));
        shop.add(new Apple("Семеренко", 120.0, 44, 50, Colors.GREEN));
        shop.add(new Apple("Семеренко", 120.0, 44, 50, Colors.GREEN));
        shop.add(new Apple("Семеренко", 120.0, 44, 50, Colors.GREEN));
        shop.add(new Apple("Джона голд", 160.0, 62, 45, Colors.RED));
        shop.add(new Apple("Джона голд", 160.0, 62, 45, Colors.RED));

        System.out.println("В магазин завезли яблоки");
        System.out.println(shop.toString());
    }
}
