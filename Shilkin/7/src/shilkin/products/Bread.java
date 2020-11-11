package shilkin.products;

import shilkin.items.FoodItem;

public class Bread extends FoodItem {

    private final int weight;

    public Bread(String productName, int productPrice, int calorific, int storagedTime, int weight) {
        super(productName, productPrice, calorific, storagedTime);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "хлеб " + productName + ", вес: " + this.weight + ", калорийность: " + calorific + ", срок годности " + storageTime + " д, цена: " + productPrice;
    }
}
