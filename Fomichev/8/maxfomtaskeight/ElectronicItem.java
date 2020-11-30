package maxfomtaskeight;

public class ElectronicItem extends ShopItem {
    static int powerUse;

    public ElectronicItem(String name, int price, int powerUse) {
        super(name, price);
        ElectronicItem.powerUse = powerUse;
    }

    public int getPowerUse() {
        return powerUse;
    }
}
