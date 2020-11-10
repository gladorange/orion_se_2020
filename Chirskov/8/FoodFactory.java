import java.util.ArrayList;
import java.util.Collection;

public class FoodFactory {
    static void fillShopWithFood(Collection<? super FoodItem> products) {
        ArrayList<FoodItem.Color> colors = new ArrayList<>();
        int weight = 0;
        FoodItem.Apple apple = new FoodItem.Apple("GoldenRose");
        products.add(apple);
        colors.add(apple.getColor());
        FoodItem.Bread bread = new FoodItem.Bread("Буханка белого", 150);
        products.add(bread);
        weight += bread.getWeight();
        System.out.println("В магазин добавлены яблоки: " + colors + " и хлеб, общим весом: " + weight);
    }
}
