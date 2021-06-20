package com.java.company.thread;

public class PriorityTest
{
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread4());
        Thread t2 = new Thread(new MyThread5());
        t1.setPriority(Thread.NORM_PRIORITY + 3);
        t1.start();
        t2.start();
    }
}

class MyThread4 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++)
        {
            System.out.println("-----"+i);
        }
    }
}

class MyThread5 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++)
        {
            System.out.println("MyThread5-----"+i);
        }
    }
}

