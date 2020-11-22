package com.druzhinin;

import java.util.ArrayList;

public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(ArrayList<? extends ShopItem> shop) {
        System.out.println("\nПросто зашедший клиент товаров: " + shop.size());

        for (ShopItem item : shop) {
            System.out.println(item.getItemName() + " - " + item.getPrice());
        }
    }
}
