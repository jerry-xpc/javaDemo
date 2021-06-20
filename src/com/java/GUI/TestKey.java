package com.java.GUI;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestKey
{
    public static void main(String[] args)
    {
        new KeyFrame().launchFrame();
    }
}

class KeyFrame extends Frame
{
    public void launchFrame()
    {
        setSize(200,200);
        setLocation(300,300);
        addKeyListener(new MyKeyMonitor());
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                setVisible(false);
                System.exit(0);
            }
        });
    }

    class MyKeyMonitor extends KeyAdapter
    {
        public void keyPressed(KeyEvent k)
        {
            int keyCode = k.getKeyCode();
            if (keyCode == KeyEvent.VK_UP)
            {
                System.out.println("UP");
            }
        }
    }
}