package maxfomtaskeight.fabric;

import maxfomtaskeight.Apple;

import java.util.Collection;
import java.util.Random;

public class AppleGarden {
    public static void fillShopWithApples(Collection<? super Apple> shop) {
        StringBuilder appleList = new StringBuilder();
        for (int i = 0; i < new Random().nextInt(3) + 2; i++) {
            shop.add(addApple(appleList));
        }
        System.out.println("В магазин добавлены яблоки: " + appleList.toString());
    }

    private static Apple addApple(StringBuilder appleList) {
        switch (new Random().nextInt(3)) {
            case (0):
                appleList.append("Жигулевка, ");
                return new Apple("Жигулевка", 15, 50, 60, "Красное");
            case (1):
                appleList.append("Грэнни, ");
                return new Apple("Грэнни", 20, 65, 90, "Зеленое");
            case (2):
                appleList.append("Весенее, ");
                return new Apple("Весеннее", 30, 70, 130, "Желтое");
            default:
                return null;
        }
    }
}
