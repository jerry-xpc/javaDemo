package com.java.javaSE.thread.pool.threadPoolExecutor;

import com.java.javaSE.thread.pool.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolDemo {
    public static void main(String[] args) {
        //单线程池，每次只执行一个线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i=0;i<20;i++){
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
