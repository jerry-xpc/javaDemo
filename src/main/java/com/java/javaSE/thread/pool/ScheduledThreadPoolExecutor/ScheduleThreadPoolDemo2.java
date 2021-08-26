package com.java.javaSE.thread.pool.ScheduledThreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolDemo2 {
    public static void main(String[] args) {
        //创建一个调度线程池，池空间为1
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        //当前系统时间毫秒
        System.out.println(System.currentTimeMillis());
        //调度通过new Runnable对象内部类执行逻辑  设定初始延迟时间  延迟时间 时间类型
        ////启动后不关闭情况下一直执行
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
        },1,3, TimeUnit.SECONDS);


        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("3------延迟一秒执行，每三秒执行一次");
                System.out.println(System.currentTimeMillis());
            }
        },1,3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("4------延迟一秒执行，每三秒执行一次");
                System.out.println(System.currentTimeMillis());
            }
        },1,3, TimeUnit.SECONDS);
    }
}
