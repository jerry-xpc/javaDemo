package com.java.company.thread;

public class SyncTest2  implements  Runnable
{
    int a = 100;

    public synchronized void m1() throws Exception
    {

        a = 1000;
        Thread.sleep(5000);
        System.out.println("a = "+a);
    }

    public synchronized void m2() throws Exception
    {
        Thread.sleep(2500);
        a = 2000;
    }

    @Override
    public void run()
    {
        try {
            m1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        SyncTest2 s2 = new SyncTest2();
        Thread t = new Thread(s2);
        t.start();

        Thread.sleep(1000);

        s2.m2();

        System.out.println(s2.a);
    }
}
