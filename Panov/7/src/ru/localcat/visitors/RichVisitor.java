package ru.localcat.visitors;

import ru.localcat.shopitems.ShopItem;

import java.util.ArrayList;
import java.util.Collection;

public class RichVisitor implements ShopVisitor{
    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {
        Collection<ShopItem> richBasket = new ArrayList<>();
        int counter = 0;

        for (ShopItem shopItem : collection) {
            if(counter % 2 == 1) {
                System.out.println("Буратино покупает " + shopItem.getName() + " за " + shopItem.getCost());
                richBasket.add(shopItem);
            }
            counter++;
        }

        collection.removeAll(richBasket);
    }
}
