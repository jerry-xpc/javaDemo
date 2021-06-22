package com.java.javaSE.thread;

public class ThreadApiDemo implements Runnable {
    public static void main(String[] args) {
        //获取当前线程对象
        Thread thread = Thread.currentThread();
        //获取当前线程的名称
        System.out.println(thread.getName());
        //获取当前线程的id
        System.out.println(thread.getId());
        //获取线程的优先级，在一般系统中的范围是0-10的值，如果没有经过设置的话，默认值为5，有些系统是0-100
        System.out.println(thread.getPriority());

        //设置线程的优先级
        /**
         * 优先级越高一定优先执行吗？
         *      不一定，只是提高了优先执行的概率
         */
        ThreadApiDemo threadApiDemo = new ThreadApiDemo();
        Thread t = new Thread(threadApiDemo);
        t.start();
        System.out.println(t.getPriority());
        //判断当前线程是否在活动运行
        System.out.println(t.isAlive());
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"i="+i);
        }
    }
}
