package com.company.thread;

public class ProducerConsumer
{
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);

        new Thread(p).start();
        new Thread(c).start();
    }
}

class WoTou
{
    int id = 0;
    WoTou(int id)
    {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WoTou : " + id;
    }
}

class SyncStack
{
    int index = 0;
    WoTou[] arrWt = new WoTou[6];

    public synchronized void push(WoTou wt) throws Exception {
        if (index == arrWt.length)
        {
            this.wait();
        }
        this.notifyAll();
        arrWt[index] = wt;
        index++;
    }

    public synchronized WoTou pop() throws Exception
    {
        if (index == 0)
        {
            this.wait();
        }
        this.notifyAll();

        index--;
        return arrWt[index];
    }
}

class Producer implements Runnable
{
    SyncStack ss = null;
    Producer(SyncStack ss)
    {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            WoTou wt = new WoTou(i);
            try {
                ss.push(wt);
                System.out.println("生产了："+wt);
                Thread.sleep((long) (Math.random() * 1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable
{
    SyncStack ss = null;
    Consumer(SyncStack ss)
    {
        this.ss = ss;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                WoTou wt = ss.pop();
                System.out.println("消费了:"+wt);
                Thread.sleep((long) (Math.random() * 1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}