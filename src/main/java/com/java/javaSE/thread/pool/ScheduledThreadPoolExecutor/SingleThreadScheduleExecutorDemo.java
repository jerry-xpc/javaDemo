package com.java.javaSE.thread.pool.ScheduledThreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduleExecutorDemo {
    public static void main(String[] args) {
        //创建一个单例调度定时线程，此线程只会存在一个线程执行
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println(System.currentTimeMillis());
        //单次启动，也就说只执行一次
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒执行");
                System.out.println(System.currentTimeMillis());
            }
        },3, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1延迟三秒执行");
                System.out.println(System.currentTimeMillis());
            }
        },10, TimeUnit.SECONDS);
    }
}
