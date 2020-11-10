package shilkin.products;

import shilkin.items.FoodItem;

public class Apple extends FoodItem {

    private final String color;

    public Apple(String productName, int productPrice, int calorific, int storageTime, String color) {
        super(productName, productPrice, calorific, storageTime);
        this.color = color;
    }

    @Override
    public String toString() {
        return "яблочко " + productName + ", цвет: " + this.color + ", калорийность: " + calorific + ", срок годности " + storageTime + " д, цена: " + productPrice;
    }
}
