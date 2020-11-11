package shilkin.visitors;

import shilkin.Exceptions.NoElementsInCollectionException;
import shilkin.Exceptions.NoExistsInCollectionException;
import shilkin.interfaces.ShopVisitor;
import shilkin.items.ElectronicItem;
import shilkin.items.ShopItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ElectronicAddictedVisitor implements ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> items) throws NoElementsInCollectionException, NoExistsInCollectionException {
        if (items.size() == 0) {
            throw new NoElementsInCollectionException("Магазин пуст");
        }
        boolean flag = false;
        for (ShopItem item : items) {
            if (item instanceof ElectronicItem) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new NoExistsInCollectionException("В магазине не продается электроника");
        }
        System.out.println("Электронные товары:");
        for (ShopItem item : items) {
            if (item instanceof ElectronicItem) {
                System.out.println(item.getProductName() + " - " + item.getProductPrice());
            }
        }
        System.out.println();
        List<ShopItem> listedItems = new ArrayList<>(items);
        ElectronicItem temporaryItem = new ElectronicItem("", 0, 0);
        int index = 0;
        for (int i = 0; i < items.size(); i++) {
            if (listedItems.get(i) instanceof ElectronicItem) {
                if (((ElectronicItem) listedItems.get(i)).getPowerInput() > (temporaryItem.getPowerInput())) {
                    temporaryItem = (ElectronicItem) listedItems.get(i);
                    index = i;
                }
            }
        }
        System.out.println(listedItems.get(index).getProductName() + " куплен по цене: " + listedItems.get(index).getProductPrice());
        items.remove(index);
    }
}
