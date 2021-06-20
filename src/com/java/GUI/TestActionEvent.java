package com.java.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent
{
    public static void main(String[] args) {
        Frame frame = new Frame("Test");
        Button button = new Button("Press Me!");
        frame.setLocation(300,300);
        frame.setSize(300,300);
        Monitor monitor = new Monitor();
        button.addActionListener(monitor);
        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

class Monitor implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("a Button has been pressed");
    }
}