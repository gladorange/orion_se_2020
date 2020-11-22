package com.druzhinin;

import java.util.ArrayList;
import java.util.Collection;

public interface ShopVisitor {
    void visitShop(ArrayList<? extends ShopItem> shop);
}
