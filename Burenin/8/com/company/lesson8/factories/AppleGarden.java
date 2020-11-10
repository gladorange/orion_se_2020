package com.company.lesson8.factories;

import com.company.lesson8.products.FoodItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppleGarden {
    public static void fillShopWithApples(Collection<? super FoodItem.Apple> collection) {
        List<FoodItem.Apple.Color> colors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            FoodItem.Apple apple = new FoodItem.Apple(String.format("Яблоко %s", i));
            colors.add(apple.getColor());
            collection.add(apple);
        }
        System.out.println("В магазин добавлены яблоки: " + colors);
    }
}
