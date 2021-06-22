package com.java.javaSE.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPoolDemo {

    public static void main(String[] args) {
        //newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<20;i++){
            executorService.execute(new Task());
        }
        //关闭线程池
        executorService.shutdown();
    }

}
