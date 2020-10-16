package com.provalov.lesson3;

public class FixPriceShop {
    private String[] items;
    private static int price = 0;
    private int happyHour;

    private static boolean emptyString( final String s ) {
        return s != null && !s.trim().isEmpty();
    }

    // Добавить один товар
    public void addItem( String item ) {
        if (emptyString(item)) {
            String[] newItems = new String[items.length + 1];
            System.arraycopy(items,0, newItems,0,items.length);
            newItems[newItems.length-1] = item;
            items = newItems;
        }
  //      System.out.println("Товар добавлен");
    }

    // Добавить товар списочно
    public void addItem( String[] items ) {
        int addCount = 0;
        for (String item : items) {
            if (emptyString(item)){
                addItem(item);
                addCount++;
            }
        }
    //    System.out.printf("Добавлено %d товаров\n", addCount);
    }

    // Удалить товар по индексу (индексы начинаются с 0)
    private void delItem(int itemIndex){
        if (itemIndex >= 0 && items.length > 0) {
            String[] newItems = new String[items.length - 1];
            System.arraycopy(items, 0, newItems, 0, itemIndex);
            if (newItems.length - itemIndex >= 0)
                System.arraycopy(items, itemIndex + 1, newItems, itemIndex, newItems.length - itemIndex);
            this.items = newItems;
        }
    }

    // Возвращает массив доступных в магазине товаров
    public String[] getItems(){
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {this.delItem(i);}
        }
        return items;
    }

    // Вывести список товаров магазина
    public void printItemsList() {
        if (items != null) {
            for (String item:items) {
                System.out.printf("%s ", item);
            }
            System.out.println();
        }else{
            System.out.println("Список товаров данного магазина пуст");
        }
    }

    // Купить товар
    public void buyItem( String item, int hour ) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)){
                System.out.printf("товар <%s> продан по цене <%d>\n", item, checkItemPrice(item, hour));
                delItem(i);
                return;
            }
        }
        System.out.printf("Товар <%s> не обнаружен\n", item);
    }

    public static void setPrice( int price ) {
        if (price >= 0) {
            FixPriceShop.price = price;
        }
    }

    private void setHappyHour( int happyHour ) {
        if (happyHour>=0 & happyHour <= 23) {
            this.happyHour = happyHour;
        }
    }

    public int getHappyHour(){
        return happyHour;
    }

    public int checkItemPrice( String item, int hour ){
        for (String s : items) {
            if (s.equals(item)) {
                if (hour == happyHour) {
                    return (int) Math.ceil(price * 0.5);
                }
                return price;
            }
        }
        return -1;
    }

    public FixPriceShop(int happyHour){
        this.setHappyHour(happyHour);
        this.items = new String[0];

    }
}
