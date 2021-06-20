package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFPassword
{
    public static void main(String[] args)
    {
        new TFFrame2();
    }
}

class TFFrame2 extends Frame
{
    TFFrame2()
    {
        TextField tf = new TextField();
        add(tf);
        tf.addActionListener(new TFActionListener2());
        tf.setEchoChar('*');
        pack();
        setVisible(true);
    }
}


class TFActionListener2 implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        TextField tf = (TextField) e.getSource();
        System.out.println(tf.getText());
        tf.setText("");
    }
}