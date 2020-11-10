package com.company.lesson8.visitors;

import com.company.lesson8.products.ElectronicItem;
import com.company.lesson8.products.ShopItem;

import java.util.Collection;

public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {
        ElectronicItem eItem = null;
        for (ShopItem item : collection) {
            if (item instanceof ElectronicItem) {
                System.out.println(item.getName() + " - " + item.getPrice());
                if (eItem == null || eItem.getPower() < ((ElectronicItem) item).getPower()) {
                    eItem = (ElectronicItem) item;
                }
            }
        }

        if (eItem != null) {
            System.out.println(eItem.getName() + " куплен по " + eItem.getPrice());
            collection.remove(eItem);
        }
    }
}
