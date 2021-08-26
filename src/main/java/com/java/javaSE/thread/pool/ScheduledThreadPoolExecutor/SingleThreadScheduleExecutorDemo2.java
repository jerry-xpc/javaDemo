package com.java.javaSE.thread.pool.ScheduledThreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduleExecutorDemo2 {
    public static void main(String[] args) {
        //创建一个单例调度定时线程，此线程只会存在一个线程执行
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println(System.currentTimeMillis());
        //启动后不关闭情况下一直执行
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("1------延迟一秒执行，每三秒执行一次");
                System.out.println(System.currentTimeMillis());
            }
        },1,3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("2------延迟一秒执行，每三秒执行一次");
                System.out.println(System.currentTimeMillis());
            }
        },10,3, TimeUnit.SECONDS);
    }
}
