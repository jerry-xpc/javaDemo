package com.java.javaSE.thread;

public class TicketSynchronizedDemo implements Runnable{
    private  int ticke = 5;
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            try {
                //在synchronized同步代码块前面添加睡眠可以给其他线程抢占资源的机会，
                // 不然可能存在某线程一直优先抢到资源不给别的线程执行机会，
                // 如果放在同步代码块里面跟不加睡眠一样的起不到效果，放同步块里面就相当于某线程在执行过程中睡眠，其他还是没有机会取得
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //添加synchronized为同步锁代码块，锁定此时其他线程只能等待不能抢占其资源
            synchronized (this){
                if (ticke > 0){
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticke--)+"张票");
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketSynchronizedDemo tsd = new TicketSynchronizedDemo();
        Thread thread = new Thread(tsd,"A");
        Thread thread1 = new Thread(tsd,"B");
        Thread thread2 = new Thread(tsd,"C");
        Thread thread3 = new Thread(tsd,"D");
        Thread thread4 = new Thread(tsd,"E");

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
