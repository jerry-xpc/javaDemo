package com.company.thread;

public class ThreadTest
{
    public static void main(String[] args)
    {
        //Runner1 runner1 = new Runner1();
        //能使用接口方式实现就不要使用继承
        //Thread t = new Thread(runner1);
        //通知CPU，让CPU去分配执行使用此方法调用
        //t.start();//正常工作中必须
        //这样会先执行子方法然后再执行main主方法
        //runner1.run();

        Runner2 runner2 = new Runner2();
        runner2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread :"+ i);
        }
    }
}

class Runner1 implements Runnable
{
    @Override
    public void run() {
        for (int i =0;i<100;i++)
        {
            System.out.println("Runnel1 :"+ i);
        }
    }
}

class Runner2 extends Thread
{
    public void run()
    {
        for (int i =0;i<100;i++)
        {
            System.out.println("Runner2 :"+i);
        }
    }
}