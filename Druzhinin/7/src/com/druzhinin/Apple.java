package com.druzhinin;

public class Apple extends FoodItem {
    Colors color;

    public Apple(String itemName, Double price, int calories, int shelfLife, Colors color) {
        super(itemName, price, calories, shelfLife);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", calories=" + calories +
                ", shelfLife=" + shelfLife +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
