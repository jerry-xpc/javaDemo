package com.java.javaSE.thread;

public class TicketThreadDemo extends Thread
{

    private static int  ticket = 5;

    public static void main(String[] args)
    {
        TicketThreadDemo ticketThreadDemo1 = new TicketThreadDemo();
        TicketThreadDemo ticketThreadDemo2 = new TicketThreadDemo();
        TicketThreadDemo ticketThreadDemo3 =  new TicketThreadDemo();
        TicketThreadDemo ticketThreadDemo4 = new TicketThreadDemo();
        TicketThreadDemo ticketThreadDemo5 = new TicketThreadDemo();

        ticketThreadDemo1.start();
        ticketThreadDemo2.start();
        ticketThreadDemo3.start();
        ticketThreadDemo4.start();
        ticketThreadDemo5.start();
    }

    @Override
    public void run()
    {
        for (int i=0;i<100;i++)
        {
            if (ticket > 0)
            {
                System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
            }
        }
    }
}
