package com.java.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestAnonymous
{
    Frame frame = new Frame("Test");
    TextField tf = new TextField(10);
    Button button = new Button("Strat");

    TestAnonymous()
    {
        frame.add(button,"North");
        frame.add(tf,"South");

        button.addActionListener(new ActionListener()
        {
            private int i;

            @Override
            public void actionPerformed(ActionEvent e)
            {
                tf.setText(e.getActionCommand() + ++i);
            }
        });

        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new TestAnonymous();
    }
}

