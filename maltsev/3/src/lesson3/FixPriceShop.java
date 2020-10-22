package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FixPriceShop {

    private String[] items;
    private final static int happyHour = 14;
    public final static int fixPrice = 49;
    private static String[] mainItemsArray = new String[] {"Товар 1","Товар 2","Товар 3","Товар 4","Товар 5","Товар 6","Товар 7","Товар 8","Товар 9","Товар 10"};

    public FixPriceShop(String ... items) {
        this.items = items;
    }

    public static void main(String[] args) {
        FixPriceShop[] shops = new FixPriceShop[3];
        for (int i = 0; i < shops.length; i++) {
            shops[i] = new FixPriceShop();

            int tmpR1 = 1 + new Random().nextInt(5); // Не более 5 товаров в магазине

            shops[i].items = new String[tmpR1];

            for (int j = 0; j < tmpR1; j++) {
                shops[i].items[j] = mainItemsArray[new Random().nextInt(mainItemsArray.length)];
            }
        }

        for (int i = 0; i < shops.length; i++) {
            System.out.println("--- Магазин "+i);
            System.out.println("1 шаг. Товары : " + Arrays.toString(shops[i].items)); // выведу товары по магазину

            // куплю товар
            int tmpR2 = new Random().nextInt(shops[i].items.length);  // Какой товар будем покупать
            int tmpHour = new Random().nextInt(24);  // В какое время

            String s = shops[i].items[tmpR2];

            //System.out.println("Покупаю "+shops[i].items[tmpR2] + ", время "+tmpHour);
            shops[i].buyItem(s, tmpHour);
            System.out.println("2 шаг. Товары:" + Arrays.toString(shops[i].items)); // выведу товары по магазину
            // попробую купить еще раз
            shops[i].buyItem(s, tmpHour);
            System.out.println("3 шаг. Товары:" + Arrays.toString(shops[i].items)); // выведу товары по магазину

        }


    }

    int checkItemPrice(String item, int hour){
        if (Arrays.asList(items).contains(item)) {
            if (hour == happyHour) {
                return fixPrice/2;
            } else {
                return fixPrice;
            }
        }else {
            return -1;
        }
    }

    String[] getItems(){
        ArrayList<String> list = new ArrayList<String>();
        for (String s : items){
            if (s != null)
                list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }

    void buyItem(String item, int hour){
        int tmpPrice = checkItemPrice(item, hour);
        if (tmpPrice != -1){
            // удаляю из списка

            ArrayList<String> tmpList = new ArrayList<String>(Arrays.asList(items));
            tmpList.remove(item);
            items = tmpList.toArray(new String[tmpList.size()]);

            System.out.println(String.format("%s продан по цене %d", item, tmpPrice));
        }else{
            System.out.println(String.format("%s не обнаружен", item));
        }


    }

}
