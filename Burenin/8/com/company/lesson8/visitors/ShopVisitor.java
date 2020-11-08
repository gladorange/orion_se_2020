package com.company.lesson8.visitors;

import com.company.lesson8.products.ShopItem;

import java.util.Collection;

public interface ShopVisitor {
    void visitShop(Collection<? extends ShopItem> collection);
}
