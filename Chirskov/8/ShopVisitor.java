import javax.swing.text.html.HTMLDocument;
import java.util.Collection;
import java.util.Iterator;

interface ShopVisitor {
    void visitShop(Collection<? extends ShopItem> products);

    public class ImJustLookingVisitor implements ShopVisitor {

        @Override
        public void visitShop(Collection<? extends ShopItem> products) {
            for (ShopItem product : products) {
                System.out.println(product);
            }
        }
    }

    public class ElectronicAddictedVisitor implements ShopVisitor {

        @Override
        public void visitShop(Collection<? extends ShopItem> products) {
            double maxPower = 0;
            ElectronicItem forRemove = null;
            for (ShopItem product : products) {
                if (product instanceof ElectronicItem) {
                    ElectronicItem item = (ElectronicItem) product;
                    if (maxPower < item.getPower()) {
                        maxPower = item.getPower();
                        forRemove = item;
                    }
                }
                System.out.println(product);
            }
            if (maxPower > 0) {
                System.out.println(forRemove + " куплен");
                products.remove(forRemove);
            }
        }
    }

    public class RichVisitor implements ShopVisitor {

        @Override
        public void visitShop(Collection<? extends ShopItem> products) {
            final Iterator iterator = products.iterator();
            int count = 1;
            while (iterator.hasNext()) {
                final ShopItem product = (ShopItem) iterator.next();
                if (count % 2 == 0){
                    System.out.println(product + " куплен");
                    iterator.remove();
                }
                count++;
            }
        }
    }
}
