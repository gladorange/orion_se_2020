package shilkin.fabrics;

import shilkin.items.FoodItem;
import shilkin.products.Apple;
import shilkin.products.Bread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FoodFactory {

    public static void fillShopWithFood(Collection<? super FoodItem> items) {
        List<FoodItem> addedFoodItems = new ArrayList<>();
        addedFoodItems.add(new Apple("Золотая осень", 40, 10, 2, "Желтый"));
        addedFoodItems.add(new Apple("Багровый румянец", 70, 20, 3, "Красный"));
        addedFoodItems.add(new Bread("Домашний", 30, 40, 1, 300));
        addedFoodItems.add(new Bread("Царский", 30, 40, 1, 300));
        items.addAll(addedFoodItems);
        int sum = 0;
        for (FoodItem addedFoodItem : addedFoodItems) {
            if (addedFoodItem instanceof Bread) {
                sum += (((Bread) addedFoodItem).getWeight());
            }
        }
        System.out.println();
        System.out.println("В магазин добавлены яблочки разных цветов и хлебушек, общим весом: " + sum);
        for (FoodItem addedFoodItem : addedFoodItems) {
            System.out.println(addedFoodItem.toString());
        }
    }
}
