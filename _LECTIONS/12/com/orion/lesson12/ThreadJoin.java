package com.orion.lesson12;

import java.util.ArrayList;

public class ThreadJoin {


    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> result = new ArrayList<>();


        System.out.println("Запускаю новый поток");
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    result.add(i * i);
                }
            }
        });
        thread.start();


        System.out.println("Поток запущен");
       // thread.join();

        System.out.println("Результат" + result.toString());








    }

}
