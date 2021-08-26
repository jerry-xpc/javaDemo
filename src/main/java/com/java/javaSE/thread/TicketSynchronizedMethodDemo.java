package com.java.javaSE.thread;

public class TicketSynchronizedMethodDemo implements Runnable{
    private  int ticke = 5;
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.sale();
        }
    }

    /**
     * 使用同步方法解决数据安全问题
     */
    public synchronized void sale(){
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        if (ticke > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticke--) + "张票");
        }
    }

    public static void main(String[] args) {
        TicketSynchronizedMethodDemo tsd = new TicketSynchronizedMethodDemo();
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
