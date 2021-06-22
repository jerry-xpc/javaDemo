package com.java.javaSE.thread.pc;

import java.util.concurrent.BlockingQueue;

public class ConsumerQueue implements Runnable{
    private BlockingQueue<Goods> blockingQueue;

    public ConsumerQueue(BlockingQueue<Goods> blockingQueue){
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        for (int i=0;i<10;i++){
            Goods goods;
            try {
                goods = blockingQueue.take();
                System.out.println("消费者消费的商品是："+goods.getBrand()+"--"+goods.getName());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
