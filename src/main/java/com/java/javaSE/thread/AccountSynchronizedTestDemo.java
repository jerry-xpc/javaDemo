package com.java.javaSE.thread;

public class AccountSynchronizedTestDemo{
    private int amount = 1000;

    public synchronized void pull(int amount,String name){
        if (this.amount >= amount){
            System.out.println(name+"准备取款");
            this.amount-=amount;
            System.out.println(name+"完成取款");
        }else{
            System.out.println("余额不足以支付"+name+"的取款,剩余"+this.amount);
        }
    }

    public static void main(String[] args) {
        AccountSynchronizedTestDemo t = new AccountSynchronizedTestDemo();
        ZhangSan zhangSan = new ZhangSan(t);
        Thread thread = new Thread(zhangSan);
        thread.start();

        CuiHua cuiHua = new CuiHua(t);
        Thread thread1 = new Thread(cuiHua);
        thread1.start();
    }
}

class ZhangSan implements Runnable{
    AccountSynchronizedTestDemo a;
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.a.pull(200,"zhangsan");
        }
    }

    public ZhangSan(AccountSynchronizedTestDemo a){
        this.a = a;
    }
}

class CuiHua implements Runnable{
    AccountSynchronizedTestDemo a;
    @Override
    public void run() {
        try {
            Thread.sleep(101);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<5;i++){
            this.a.pull(100,"CuiHua");
        }
    }

    public CuiHua(AccountSynchronizedTestDemo a){
        this.a = a;
    }
}