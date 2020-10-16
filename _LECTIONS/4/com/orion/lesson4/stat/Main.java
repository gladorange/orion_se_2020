package com.orion.lesson4.stat;

public class Main {


    public static void main(String[] args) {


        Shop magazin = new ElectronicShop();

   //     System.out.println(magazin.getDefaultShopName()); неправильно, через инстанс не стоит вызывать статические методы
        System.out.println(Shop.getDefaultShopName());
    }
}
