package com.orion;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.orion.MyExecutor.Executor;

public class ScheduledExecutor {


    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);


        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Я выполнюясь каждую секунду"), 2000, 1000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.schedule(() -> System.out.println("Я выполняюсь один раз через 5 секунду"), 5, TimeUnit.SECONDS);

    }
}
