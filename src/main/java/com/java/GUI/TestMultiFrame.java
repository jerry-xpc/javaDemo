package com.java.GUI;

import java.awt.*;

public class TestMultiFrame
{
    public static void main(String[] args)
    {
        MyFrame f1 = new MyFrame(100,100,200,200,Color.BLUE);
        MyFrame f2 = new MyFrame(300,100,200,200,Color.YELLOW);
        MyFrame f3 = new MyFrame(100,300,200,200,Color.green);
        MyFrame f4 = new MyFrame(300,300,200,200,Color.magenta);


    }
}

class MyFrame extends Frame
{
    public static int id = 0;
    MyFrame(int x,int y,int w,int h,Color c)
    {
        super("MyFrame:"+ (++id));
        setBackground(c);
        setLayout(null);
        setBounds(x,y,w,h);
        setVisible(true);
    }

}