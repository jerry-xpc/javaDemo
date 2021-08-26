package com.java.javaSE.thread;

public class Test implements Runnable
{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"============"+i);
            try {
                //同伙时间差来完成两个循环的数据，顺势逆势之间的交替
                Thread.sleep(1005);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Test test = new Test();
        Thread thread = new Thread(test);
        thread.start();

        for (int i=10;i>0;i--){
            System.out.println(Thread.currentThread().getName()+"---------------"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
