package com.java.javaSE.thread.pool.ScheduledThreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolDemo {
    public static void main(String[] args) {
        //创建一个延迟定时器线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println(System.currentTimeMillis());
        //调度通过创建线程对象的方式启用线程，new Runnable{run(){逻辑实体}},延迟时间,延迟单位
        //单次启动，也就说只执行一次
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒执行");
                System.out.println(System.currentTimeMillis());
            }
        },3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
