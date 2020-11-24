package com.druzhinin;

import java.util.ArrayList;

public class RichVisitor implements ShopVisitor {
    @Override
    public void visitShop(ArrayList<? extends ShopItem> shop) {
        System.out.println("\nДо богатея товаров: " + shop.size());

        for (int i = 0; i < shop.size(); i++) {
            if ((i % 2) == 0) {
                ShopItem item = shop.get(i);
                System.out.printf("Богатей купил %s по цене %s\n", item.getItemName(), item.getPrice());
                shop.remove(item);
            }
        }

        for (ShopItem item : shop) {
            System.out.println(item.getItemName() + " - " + item.getPrice());
        }

        System.out.println("После богатея товаров: " + shop.size());
    }
}
