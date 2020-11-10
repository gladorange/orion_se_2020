package com.company.lesson8.visitors;

import com.company.lesson8.products.ShopItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RichVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {
        List<ShopItem> removeCollection = new ArrayList<>();
        int index = 0;
        for (ShopItem item : collection) {
            if (index % 2 == 1) {
                System.out.println(item.getName() + " куплен по " + item.getPrice());
                removeCollection.add(item);
            }
            ++index;
        }
        collection.removeAll(removeCollection);
    }
}
