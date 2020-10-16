package com.provalov.lesson3;

public class Lesson3 {
    private static class ShopGenerator {
        private static int shopCount;

        public FixPriceShop createShop(int productCount, int productTypeCount){
            if (productCount > 0 && productCount <= 100 && productTypeCount > 0 && productTypeCount <= 100) {
                FixPriceShop shop = new FixPriceShop((int) (Math.random() * 24));
                shopCount++;
                String[] addItems = new String[productCount];
                for (int j = 0; j < addItems.length; j++) {
                    addItems[j] = "Product" + ((int) (Math.random() * productTypeCount) + 1);
                }
                shop.addItem(addItems);
                return shop;
            }else{
                System.out.println("Неправильные параметры для создания магазина");
                return null;
            }
        }

        public int getShopCount(){
            return shopCount;
        }
    }

    private static int getShopHappyHour(FixPriceShop shop, String item){
        int tmpPrice = shop.checkItemPrice(item, 0);
        int happyHour = 0;
        for (int i = 1; i < 24; i++) {
            if (tmpPrice != shop.checkItemPrice(item, i)){
                if (Math.min(tmpPrice, shop.checkItemPrice(item, i)) != tmpPrice) {
                    happyHour = i;
                }
            }
        }
        return happyHour;
    }

    private static String getRandomItem(FixPriceShop shop){
        String[] itemListShop = shop.getItems();
        return itemListShop[(int)(Math.random()*itemListShop.length)];
    }

    private static int getCountRandomItem(FixPriceShop shop, String item){
        int res=0;
        String[] itemListShop = shop.getItems();
        for (String s:itemListShop) {
            if (s.equals(item)) {res++;}
        }
        return res;
    }

    public static void main(String[] args) {
        FixPriceShop.setPrice(35);
        ShopGenerator Sg = new ShopGenerator();

        int shopCount = 3;
        FixPriceShop[] shopArray = new FixPriceShop[shopCount];
        String[] randomItemArray = new String[shopCount];
        int[] countRandomItemArray = new int[shopCount];
        for (int i = 0; i < shopCount; i++) {
            shopArray[i] = Sg.createShop((int)(Math.random()*5)+5, (int)(Math.random()*4)+4);
            System.out.printf("Магазин %d\n", i+1);
            shopArray[i].printItemsList();
            randomItemArray[i] = getRandomItem(shopArray[i]);
            System.out.printf("Случайный продукт для магазина %d: %s\n", i+1, randomItemArray[i]);
            System.out.printf("Счастливый час: %d\n",  getShopHappyHour(shopArray[i], randomItemArray[i]));
            countRandomItemArray[i] = getCountRandomItem(shopArray[i], randomItemArray[i]);
            System.out.printf("Количество товара: %d\nПопробуем купить %d раз\n", countRandomItemArray[i], countRandomItemArray[i]+1);
            for (int j = 0; j < countRandomItemArray[i] + 1; j++) {
                shopArray[i].buyItem(randomItemArray[i], getShopHappyHour(shopArray[i], randomItemArray[i]));
                shopArray[i].printItemsList();
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}

//Задание 3. счастливые часы
//
//   +     Создайте класс FixPriceShop - сеть магазинов, которая продает товары по одной цене.
//        В классе создайте поле items - массив товаров (товар - это просто название, тип String)
//        Во всех магазинах - одинаковая цена на все товары, например, все магазины продают товары по 49.
//        Во всех магазинах действует акции "счастливый час" - час (от 0 до 23), когда действует скидка 50%
//        В каждом магазине "счастливый час" разный. , т.е. какой-то магазин продает со скидкой в 11, а другой в 23.
//
//   +     - В классе FixPriceShop определите метод  int checkItemPrice(String item, int hour) - первый аргумент - это название товара, который покупатель собирается купить,
//        второй аргумент - время покупки.
//        Метод должен возвращать цену.
//        Если время покупки совпадает со счастливым часом - то должна быть учтена скидка 50%.
//        Если указанный товар не обнаружен - то метод должен вернуть -1.
//
//   +     - В классе FixPriceShop определите метод String[] getItems() - который возвращает массив доступных товаров в магазине.
//        В возвращенном массиве не должно быть null элементов.
//
//    +    - В классе FixPriceShop определите метод void buyItem(String item, int hour) - который выводит на экран надпись "товар <> продан по цене <>".
//        Цена выводится с учетом времени. После этого, из массива товаров купленный товар должен быть удален.
//        Если такого товара нет - выведите на экран "товар <> не обнаружен"
//
//    +    Создайте 3 магазина
//    +    Каждый магазин заполните случайными товарами. Лучше будет, если каждый магазин получит разный набор товаров.
//  +      Из каждого магазина выберите случайный товар (для этого придется получить сначала список всех товаров)
//   +     и найдите оптимальное время для его покупки (т.е. время, когда действует счастливый час) используя функцию checkItemPrice
//
//        Купите этот товар.
//    +   попробуйте купить этот же самый товар еще раз, посмотрите консоль и убедитесь, что товар не обнаружен (при условии, что одинаковых товаров не было)
//
//        Советы:
//        - для хранение единой цены используйте статическую переменную.
//        Значение можете задать константой или использовать класс Random() для заполнения случайным числом.
//        - Для заполнения магазина товарами используйте конструктор.
//        Можете передать список в магазин или использовать конструктор без параметров и генерировать список внутри параметра.
