package com.java.javaSE.thread;

/**
 * 第一种实现多线程的时候：
 *      1、需要集成Thread类
 *      2、必须要重写run方法，指的是核心执行逻辑
 *      3、线程在启动的时候，不要直接调用run方法，而是要通过start()
 *      4、每次运行相同代码，出来的结果可能不一样，原因在于多线程谁先抢占资源无法进行人为控制
 * 第二种实现方式：
 *      1、实现Runnable接口
 *      2、重写run方法
 *      3、创建Thread对象，将刚刚创建好的runnable的子类实现作为thread的构造参数
 *      4、通过thread.start()进行启动
 * 两种实现方式那种好：
 *      1、推荐使用第二种，接口实现，java是单继承，将继承关系给最重要的类
 *      2、使用runnable接口之后不需要给共享变量添加static关键字，每次创建一个对象，作为共享对象即可
 */
public class ThreadDemo extends Thread
{
    @Override
    public void run()
    {
        for (int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName()+"======================="+i);
        }
    }

    public static void main(String[] args)
    {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        for (int i=0;i<5;i++)
        {
            System.out.println(Thread.currentThread().getName()+"---------------------"+i);
        }
    }
}
