package ru.localcat.visitors;


import ru.localcat.shopitems.ShopItem;

import java.util.Collection;

public interface ShopVisitor {
    void visitShop(Collection<? extends ShopItem> collection);
}
