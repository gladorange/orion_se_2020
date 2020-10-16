package ru.localcat;

public class FixPriceShop {
    public final static int COST = 49;
    private final int discount = 50;
    private String[] items;
    private int itemsCount = 0;
    private int happyHour;

    public FixPriceShop(String... items) {
        this.itemsCount = items.length;
        this.items = items;
    }

    public int getHappyHour() {
        return happyHour;
    }

    public void setHappyHour(int happyHour) throws Exception {
        this.happyHour = validateHour(happyHour);
    }

    public String[] getItems() {
        int realItemsCounter = 0;
        String[] realItems = new String[itemsCount];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                realItems[realItemsCounter] = items[i];
                realItemsCounter++;
            }
        }
        return realItems;
    }

    public void buyItem(String item, int hour) {
        try {
            int itemPrice = checkItemPrice(item, hour);
            if (itemPrice != -1) {
                System.out.println("товар " + item + " продан по цене " + itemPrice);
                itemsCount--;
                for (int i = 0; i < items.length; i++) {
                    if (items[i].equals(item)) {
                        items[i] = null;
                    }
                }
            } else {
                System.out.println("товар " + item + " не обнаружен");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int validateHour(int hour) throws Exception {
        if (happyHour >= 0 && happyHour <= 23) {
            return hour;
        } else {
            throw new Exception("Счастливый час должен быть в диапазоне [0..23]");
        }
    }

    public int checkItemPrice(String item, int hour) throws Exception {
        int itemsLength = items.length;
        if (itemsLength > 0) {
            for (int i = 0; i < itemsLength; i++) {
                if (items[i] != null) {
                    if (items[i].equals(item)) {
                        if (this.happyHour == validateHour(hour)) {
                            return COST * (100 - discount) / 100;
                        } else {
                            return COST;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
