package com.orion;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutor {


    static class Executor extends Thread {


        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();


        void submit(Runnable task) {
            taskQueue.add(task);
        }


        @Override
        public void run() {

            while (true) {
                try {
                    final Runnable take = taskQueue.take();
                    take.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        public static void main(String[] args) throws InterruptedException {
            Executor executor = new Executor();
            executor.start();


           /* executor.submit(() -> {
                try {
                    Thread.sleep(5000000);
                } catch (InterruptedException e) {
                    System.out.println("Меня прервали, заканчиваю выполнение");
                }
                System.out.println("Я задача один!");
            }); */

            executor.submit(() -> {
                long startTime = System.currentTimeMillis();

                while (System.currentTimeMillis() - startTime < 10000) {
                    if (Thread.interrupted()) {
                        System.out.println("Меня прервали, завершаю выполнение");
                        return;
                    }
                }

                System.out.println("Я задача один !");
            });
            executor.submit(() -> {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Задачу 2 прервали, завершаю выполнение");
                }
                System.out.println("Я задача два!");
            });


            Thread.sleep(2000);
            System.out.println("Две секунды прошло, завершаем задачу");
            executor.interrupt();

            System.out.println("Конец main");
        }


    }
}
