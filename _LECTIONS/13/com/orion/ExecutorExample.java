package com.orion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class ExecutorExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

/*
        for (int i = 0; i < 20; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ThreadLocalRandom.current().nextInt(0, 10));
                }
            });
        }*/


        List<Future<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final Future<Integer> submit = service.submit(new Callable<Integer>() {
                public Integer call() {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return ThreadLocalRandom.current().nextInt(0, 10);
                }
            });

            result.add(submit);
        }


        for (Future<Integer> integerFuture : result) {
            System.out.println(integerFuture.get());
        }


    }
}
