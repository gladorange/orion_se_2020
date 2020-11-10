package com.company.lesson8.factories;

import com.company.lesson8.products.FoodItem;

import java.util.Collection;

public class FoodFactory {
    public static void fillShopWithFood(Collection<? super FoodItem> collection) {
        FoodItem.Apple apple = new FoodItem.Apple("Яблоко");
        collection.add(apple);
        FoodItem.Bread bread = new FoodItem.Bread("Хлеб");
        collection.add(bread);
        System.out.println("В магазин добавлены яблоки: " + apple.getColor() + " и хлеба, общим весом: " + bread.getWeight());
    }
}
