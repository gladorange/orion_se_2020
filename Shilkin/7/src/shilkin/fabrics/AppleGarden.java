package shilkin.fabrics;

import shilkin.products.Apple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppleGarden {

    public static void fillShopWithApples(Collection<? super Apple> items) {
        List<Apple> addedAppleItems = new ArrayList<>();
        addedAppleItems.add(new Apple("Золотая осень", 40, 10, 2, "Желтый"));
        addedAppleItems.add(new Apple("Багровый румянец", 70, 20, 3, "Красный"));
        addedAppleItems.add(new Apple("Живая услада", 45, 15, 2, "Зеленый"));
        addedAppleItems.add(new Apple("Зеленый рай", 50, 5, 2, "Зеленый"));
        items.addAll(addedAppleItems);
        System.out.println("В магазин добавлены яблочки:");
        for (Apple addedAppleItem : addedAppleItems) {
            System.out.println(addedAppleItem.toString());
        }
    }
}
