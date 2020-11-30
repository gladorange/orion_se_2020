package maxfomtaskeight.fabric;

import maxfomtaskeight.Apple;
import maxfomtaskeight.Bread;
import maxfomtaskeight.FoodItem;

import java.util.Collection;
import java.util.Random;

public class FoodFactory {
    static int totalWeight=0;
    public static void fillShopWithFood(Collection<? super FoodItem> shop) {
        StringBuilder colors = new StringBuilder();

        for (int i = 0; i < new Random().nextInt(3) + 2; i++) {
            shop.add(addFood(colors));
        }

        System.out.printf("В магазин добавлены яблоки: %sи хлеб, общим весом: %d\n",
                colors.toString(), totalWeight);
        totalWeight=0;
    }

    private static FoodItem addFood(StringBuilder colors) {
        switch (new Random().nextInt(4)) {
            case (0):
                colors.append("Желтое, ");
                return new Apple("Весеннее", 30, 70, 130, "Желтое");
            case (1):
                colors.append("Красное, ");
                return new Apple("Жигулевка", 15, 50, 60, "Красное");
            case (2):
                totalWeight+=500;
                return new Bread("Сормовский", 50, 300, 3, 500);
            case (3):
                totalWeight+=900;
                return new Bread("Буханка", 40, 150, 5, 900);
            default:
                return null;
        }
    }

}
