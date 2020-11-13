package shilkin.visitors;

import shilkin.Exceptions.NoElementsInCollectionException;
import shilkin.interfaces.ShopVisitor;
import shilkin.items.ShopItem;

import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> items) throws NoElementsInCollectionException {
        if (items.size() == 0) {
            throw new NoElementsInCollectionException("Магазин пуст");
        }
        for (ShopItem item : items) {
            System.out.println(item.getProductName() + " - " + item.getProductPrice());
        }
    }
}
