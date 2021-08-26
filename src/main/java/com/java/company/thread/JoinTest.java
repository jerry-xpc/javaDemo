package com.java.company.thread;

public class JoinTest
{
    public static void main(String[] args)
    {
        MyThread2 myThread2 = new MyThread2("ABCDEFG");
        myThread2.start();
        try {
            myThread2.join();
        }
        catch (InterruptedException e)
        {
            return;
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println("i am main thread ");
        }
    }
}

class MyThread2 extends Thread
{
    MyThread2(String s)
    {
        super(s);
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("i am "+getName());
        }

        try {
            sleep(1000);
        }
        catch (InterruptedException e)
        {
            return;
        }
    }
}
