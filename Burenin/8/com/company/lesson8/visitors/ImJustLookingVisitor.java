package com.company.lesson8.visitors;

import com.company.lesson8.products.ShopItem;

import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {
        for (ShopItem item : collection) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
    }
}
