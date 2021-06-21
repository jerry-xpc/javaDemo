package com.java.javaSE.thread;

public class JoinTestDemo{
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread = new Thread(myRun);
        thread.start();

        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-----"+i);
            if (i==4){
                try {
                    //join调用该方法的线程强制执行，其他线程处于阻塞状态，该线程执行完毕后，其他线程再执行
                    thread.join();
                    System.out.println(Thread.currentThread().getName()+"============"+i+"强制执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
