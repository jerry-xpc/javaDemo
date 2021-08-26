package com.java.javaSE.thread.pool.threadPoolExecutor;

import com.java.javaSE.thread.pool.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        //创建一个指定的大小线程池，每次执行指定数量线程，其余的在阻塞队列中等待执行完毕后再执行
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0;i<20;i++){
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
