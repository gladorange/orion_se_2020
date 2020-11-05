package ru.localcat.visitors;

import ru.localcat.shopitems.ShopItem;

import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor{
    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {
        for (ShopItem shopItem : collection) {
            System.out.println("Я просто смотрю: " + shopItem.getName() + " - " + shopItem.getCost() );
        }
    }
}
