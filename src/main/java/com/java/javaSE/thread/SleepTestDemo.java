package com.java.javaSE.thread;

public class SleepTestDemo {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread = new Thread(myRun);
        thread.start();

        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"============"+i);
            if (i==3){
                try {
                    //执行后，线程会出现阻塞，待阻塞时间过后，同样的进入就绪状态等待CPU资源的抢占，抢占资源后进入运行状态进行代码逻辑实现
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
