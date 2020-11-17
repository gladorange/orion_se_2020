package com.orion;

import java.io.File;
import java.io.IOException;

public class ThreadStop implements Runnable{

    static Object lock = new Object();


    @Override
    public void run() {

        synchronized (lock) {
            try {
                final File file = new File("very big file.txt");
                file.createNewFile();

                long startTime = System.currentTimeMillis();

                while (System.currentTimeMillis() - startTime < 10000) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Меня остановили!");
                        file.delete();
                        return;

                    }
                }

                System.out.println("Работа сделана, файл удаляем");


                file.delete();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new ThreadStop());
        thread.start();


        Thread.sleep(500);
        thread.interrupt();


    }
}
