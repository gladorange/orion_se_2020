package com.druzhinin;

import java.util.ArrayList;

public class FoodFactory {
    public void fillShopWithFood(ArrayList<? super FoodItem> shop) {
        shop.add(new Apple("Наливное", 60.0, 55, 25, Colors.YELLOW));
        shop.add(new Apple("Наливное", 60.0, 55, 25, Colors.YELLOW));
        shop.add(new Apple("Семеренко", 120.0, 44, 50, Colors.GREEN));
        shop.add(new Apple("Семеренко", 120.0, 44, 50, Colors.GREEN));
        shop.add(new Apple("Семеренко", 120.0, 44, 50, Colors.GREEN));
        shop.add(new Apple("Джона голд", 160.0, 62, 45, Colors.RED));
        shop.add(new Bread("Ржаной", 30.5, 259, 3, 500));
        shop.add(new Bread("Батон", 28.5, 266, 3, 400));
        shop.add(new Bread("Ржаной", 30.5, 259, 3, 500));
        shop.add(new Bread("Батон", 28.5, 266, 3, 400));
        shop.add(new Bread("Ржаной", 30.5, 259, 3, 500));
        shop.add(new Bread("Батон", 28.5, 266, 3, 400));
        shop.add(new Bread("Булочка с изюмом", 25.0, 310, 2, 150));
        shop.add(new Bread("Булочка с изюмом", 25.0, 310, 2, 150));
        shop.add(new Bread("Булочка с изюмом", 25.0, 310, 2, 150));

        System.out.println("В магазин завезли продукты");
        System.out.println(shop.toString());
    }
}
