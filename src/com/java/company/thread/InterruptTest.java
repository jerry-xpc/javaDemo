package com.company.thread;

import java.util.Date;

public class InterruptTest
{
    public static void main(String[] args)
    {
        MyThread myThread = new MyThread();
        myThread.start();
        try
        {
            Thread.sleep(10000);
        }
        catch (Exception e)
        {
            return;
        }
        myThread.interrupt();
    }
}

class MyThread extends Thread
{
    @Override
    public void run()
    {
        while (true)
        {
            System.out.println("===="+ new Date() +"====");

            try{
                sleep(1000);
            }
            catch (Exception e)
            {
                return;
            }
        }
    }
}