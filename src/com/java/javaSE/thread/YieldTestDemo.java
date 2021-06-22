package com.java.javaSE.thread;

public class YieldTestDemo {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread = new Thread(myRun);
        thread.start();

        for (int i=0;i<10;i++){
            if (i==5){
                //当前正在执行的线程暂停一次，允许其他线程执行，不阻塞，线程进入就绪状态，如果没有其他等待的线程，这个时候就会立马恢复执行
                Thread.yield();
                System.out.println(Thread.currentThread().getName()+"=========="+i+",礼让一次");
            }else{
                System.out.println(Thread.currentThread().getName()+"==============="+i);
            }
        }
    }
}
