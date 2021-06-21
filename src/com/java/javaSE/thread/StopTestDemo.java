package com.java.javaSE.thread;

public class StopTestDemo {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread = new Thread(myRun);
        thread.start();

        for (int i=0;i<10;i++){
            if (i==5){
                //当前线程终止结束，不在执行当前线程并销毁
                thread.stop();
                System.out.println(Thread.currentThread().getName()+"==========="+i+",线程终止结束");
            }else {
                System.out.println(Thread.currentThread().getName()+"============="+i);
            }
        }
    }
}
