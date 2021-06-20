package com.java.javaSE.thread;

public class JoinTest {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread = new Thread(myRun);
        thread.start();

        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"---------"+i);
            if (i==3){
                try {
                    //使主线程进入阻塞状态，等待当前线程执行完成后释放并进入就绪状态，重新去抢占CPU资源进入运行状态执行代码逻辑
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
