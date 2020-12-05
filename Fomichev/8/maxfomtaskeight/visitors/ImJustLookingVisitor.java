package maxfomtaskeight.visitors;

import maxfomtaskeight.ShopItem;
import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        shop.forEach(shopItem -> System.out.printf("\n%s - %d;", shopItem.getName(), shopItem.getPrice()));
    }
}
