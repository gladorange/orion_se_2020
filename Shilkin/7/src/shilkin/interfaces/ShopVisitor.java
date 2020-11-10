package shilkin.interfaces;

import shilkin.Exceptions.NoElementsInCollectionException;
import shilkin.Exceptions.NoExistsInCollectionException;
import shilkin.items.ShopItem;

import java.util.Collection;

public interface ShopVisitor {
    void visitShop(Collection<? extends ShopItem> items) throws NoElementsInCollectionException, NoExistsInCollectionException;
}
