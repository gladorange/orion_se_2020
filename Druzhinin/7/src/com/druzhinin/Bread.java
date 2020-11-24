package com.druzhinin;

public class Bread extends FoodItem{
    int weight;

    public Bread(String itemName, Double price, int calories, int shelfLife, int weight) {
        super(itemName, price, calories, shelfLife);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "weight=" + weight +
                ", calories=" + calories +
                ", shelfLife=" + shelfLife +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
