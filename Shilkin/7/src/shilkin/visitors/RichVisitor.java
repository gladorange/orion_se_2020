package shilkin.visitors;

import shilkin.Exceptions.NoElementsInCollectionException;
import shilkin.interfaces.ShopVisitor;
import shilkin.items.ShopItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RichVisitor implements ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> items) throws NoElementsInCollectionException {
        if (items.size() == 0) {
            throw new NoElementsInCollectionException("Магазин пуст");
        }

        List<ShopItem> shopItems = new ArrayList<>(items);
        List<ShopItem> deletedItems = new ArrayList<>();
        for (int i = 0; i < shopItems.size(); i++) {
            if (i % 2 == 0) {
                deletedItems.add(shopItems.get(i));
            }
        }
        shopItems.removeAll(deletedItems);
        for (ShopItem shopItem : shopItems) {
            System.out.println(shopItem.getProductName() + " куплен по " + shopItem.getProductPrice());
        }
    }
}
