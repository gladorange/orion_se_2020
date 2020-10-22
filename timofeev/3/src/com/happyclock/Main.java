package com.happyclock;
import javafx.util.Pair;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        FixPriceShop.setDiscount(50);
        FixPriceShop.setPrise(49);
        String [] products_list = new String[5];
        products_list[0]= "картошка";
        products_list[1]= "марковка";
        products_list[2]= "клубника";
        products_list[3]= "груша";
        products_list[4]= "яблоки";

        FixPriceShop[] shops = new FixPriceShop[3];
        shops[0] = new FixPriceShop(Main.getRandomProducts(products_list),Main.getRandomDiscountHours());
        shops[1] = new FixPriceShop(Main.getRandomProducts(products_list),Main.getRandomDiscountHours());
        shops[2] = new FixPriceShop(Main.getRandomProducts(products_list),Main.getRandomDiscountHours());

        //test getDiscountHours
        for (int i =0; i < shops.length; ++i){
            System.out.printf("Товары хранимые '%d' магазином: \n    ",i);
            for (int j=0; j< shops[i].getItems().length; ++j ){
                System.out.printf("%s ",shops[i].getItems()[j]);
            }
            System.out.printf("\n    Часы скидки '%d'-%d\n",shops[i].getDiscountHours().getKey(),shops[i].getDiscountHours().getValue());
        }
        System.out.printf("checkItemPrice - поиск товара '%s' в магазине - %d, во время - %d , цена равна %d \n", products_list[0], 0, 13, shops[0].checkItemPrice(products_list[0],13));
        System.out.printf("checkItemPrice - поиск товара '%s' в магазине - %d, во время - %d , цена равна %d \n", products_list[2], 1, 2, shops[1].checkItemPrice(products_list[2],2));
        System.out.printf("checkItemPrice - поиск товара '%s' в магазине - %d, во время - %d , цена равна %d \n", products_list[3], 2, 11, shops[2].checkItemPrice(products_list[3],11));

        //test buyItem
        Random random = new Random();
        int index = random.nextInt(shops[0].getItems().length);
        String itemName = shops[0].getItems()[index];
        shops[0].buyItem(itemName,10);
        shops[0].buyItem(itemName,10);
    }

    public static String [] getRandomProducts(String[] products_list) {
        String[] randomProductList = new  String[3];
        for (int i = 0; i < 3; ++i) {
            Random random = new Random();
            int index = random.nextInt(products_list.length);
            while (isIemPresentInList(products_list[index], randomProductList)) {
                 index = random.nextInt(products_list.length);
            }
            randomProductList[i] = products_list[index];
        }
        return randomProductList;
    }

    public static Pair  <Integer,Integer> getRandomDiscountHours() {
        Integer start_hour = (Integer)(int)(Math.random() *23);
        Integer finish_hour = (Integer)(int)(Math.random() *23);
        Pair discountHours = new Pair <Integer,Integer>(start_hour, finish_hour);
        return discountHours;
    }

    public static boolean isIemPresentInList(String item, String[] list) {
        for (String list_item: list) {
            if (list_item == item) {
                return true;
            }
        }
        return false;
    }
}