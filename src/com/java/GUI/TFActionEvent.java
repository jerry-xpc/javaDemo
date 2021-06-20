package com.java.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFActionEvent
{
    public static void main(String[] args)
    {
        new TFrame();
    }
}

class TFrame extends Frame
{
    TFrame()
    {
        TextField tf = new TextField();
        add(tf);
        tf.addActionListener(new TFActionListener());
        pack();
        setVisible(true);
    }
}

class TFActionListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        TextField textField = (TextField) e.getSource();
        System.out.println(textField.getText());
        textField.setText("");
    }
}