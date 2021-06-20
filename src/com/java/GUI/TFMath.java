package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFMath
{
    public static void main(String[] args)
    {
        new TFFrame().launchFrame();
    }
}

class TFFrame extends Frame
{
    TextField num1,num2,num3;
    public void launchFrame()
    {
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(15);
        Label label = new Label("+");
        Button button= new Button("=");
        button.addActionListener(new MyMonitor2());
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);
        pack();
        setVisible(true);
    }

    class MyMonitor2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            num3.setText(""+(n1 * n2));
        }
    }
}

class MyMonitor implements ActionListener
{
    TextField num1,num2,num3;
    MyMonitor(TextField num1,TextField num2,TextField num3)
    {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    TFFrame tfFrame = null;
    MyMonitor(TFFrame tfFrame)
    {
        this.tfFrame = tfFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int n1 = Integer.parseInt(tfFrame.num1.getText());
        int n2 = Integer.parseInt(tfFrame.num2.getText());
        tfFrame.num3.setText("" + (n1 + n2));
    }
}