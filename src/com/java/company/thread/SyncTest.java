package com.company.thread;

public class SyncTest implements Runnable
{
    Timer timer = new Timer();

    public static void main(String[] args)
    {
        SyncTest syncTest = new SyncTest();
        Thread t1 = new Thread(syncTest);
        Thread t2 = new Thread(syncTest);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}

class Timer
{
    private static int num = 0;

    public synchronized void add(String name)
    {
        synchronized (this)
        {
            num++;
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {

            }
            System.out.println(name+",你是第"+num+"个使用timr的线程");
        }
    }
}