package com.java.javaSE.thread;

public class TicketRunnableDemo implements Runnable
{
    private int ticket = 5;

    @Override
    public void run()
    {
        for (int i=0;i<100;i++)
        {
            if(ticket > 0)
            {
                System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
            }
        }
    }

    public static void main(String[] args)
    {
        TicketRunnableDemo ticketRunnableDemo = new TicketRunnableDemo();
        Thread thread1 = new Thread(ticketRunnableDemo);
        Thread thread2 = new Thread(ticketRunnableDemo);
        Thread thread3 = new Thread(ticketRunnableDemo);
        Thread thread4 = new Thread(ticketRunnableDemo);
        Thread thread5 = new Thread(ticketRunnableDemo);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
