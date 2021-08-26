package com.java.company.thread;

public class YieldTest
{
    public static void main(String[] args)
    {
        MyThread3 myThread3 = new MyThread3("abc");
        MyThread3 myThread31 = new MyThread3("efg");

        myThread3.start();
        myThread31.start();
    }
}

class MyThread3 extends Thread
{
    MyThread3(String s)
    {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName()+": "+i);
            if (i%10==0)
            {
                yield();
            }
        }
    }
}