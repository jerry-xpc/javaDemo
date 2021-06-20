package com.GUI;

import java.awt.*;

public class TestPaint
{
    public static void main(String[] args)
    {
        new PaintFrame().launchFrame();
    }
}

class PaintFrame extends Frame {
    public void launchFrame() {
        setBounds(200, 200, 640, 480);
        setVisible(true);
    }

    public void paint(Graphics g)
    {



        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(50,50,30,30);
        g.setColor(Color.GREEN);
        g.fillOval(80,80,40,40);
        g.setColor(color);
    }
}