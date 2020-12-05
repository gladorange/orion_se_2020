package maxfomtaskeight.visitors;

import maxfomtaskeight.ShopItem;
import java.util.Collection;

public interface ShopVisitor {

    void visitShop(Collection<? extends ShopItem> shop);
}
