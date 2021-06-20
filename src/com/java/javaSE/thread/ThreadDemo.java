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
 * 线程的生命周期：
 *      1、新生状态：当创建好当前线程对象之后，没有启动之前（调用start方法之前）
 *          ThreadDemo threadDemo = new ThreadDemo();
 *          TicketRunnableDemo ticketRunnableDemo = new TicketRunnableDemo();
 *      2、就绪状态：准备开始执行，并没有执行，表示调用start()方法之后，当对应的线程创建完成，且调用start()方法后，所有的线程会添加到一个就绪队列中，所有的线程会同时去抢占CUP的资源
 *      3、运行状态：当当前进程取到CPU资源后，就绪队列中的所有线程会去抢占CPU的资源，谁先抢到谁先执行，在执行的过程中叫做运行状态，抢占到CPU资源，执行代码逻辑开始
 *      4、死亡状态：当运行中的线程正常执行完所有的代码逻辑或者因为异常情况导致程序结束叫做死亡状态
 *          进入死亡状态方式：
 *              （1）正常运行完成且结束
 *              （2）人为中断执行，比如使用stop()方法
 *              （3）程序抛出未捕获的异常
 *      5、阻塞状态：在程序运行过程中，发生某些异常情况，导致当前线程无法再顺利执行下去，此时进入阻塞状态，进入阻塞状态的原因消除之后，所有的阻塞队列会再次进入就绪状态中，随机抢占CPU的资源，等待执行
 *          进入阻塞状态方式：
 *              （1）sleep()方法
 *              （2）等待io资源
 *
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
