package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent2
{
    public static void main(String[] args) {
        Frame f = new Frame("Test");
        Button b1 = new Button("Start");
        Button b2 = new Button("Stop");

        Monitor2 m = new Monitor2();
        b1.addActionListener(m);
        b2.addActionListener(m);
        b2.setActionCommand("game over");

        f.add(b1,BorderLayout.NORTH);
        f.add(b2,BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}

class Monitor2 implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("a button has been pressed,the relative info is:\n"+e.getActionCommand());
    }
}