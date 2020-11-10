import java.util.Collection;

public class ElectronicFabric {
    static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> electronicItems) {
        ElectronicItem.TV tv = new ElectronicItem.TV("TV");
        ElectronicItem.Refrigerator refrigerator = new ElectronicItem.Refrigerator("Fridge");
        electronicItems.add(tv);
        electronicItems.add(refrigerator);
        System.out.println("В магазин добавлена электроника: " + electronicItems);
    }
}
