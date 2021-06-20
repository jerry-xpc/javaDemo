package com.GUI;

import java.awt.*;

public class TestGridLayout
{
    public static void main(String[] args) {
        Frame frame = new Frame("GridLayout Example");
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        Button b6 = new Button("b6");

        frame.setLayout(new GridLayout(3,2));
        frame.setSize(500,500);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.pack();
        frame.setVisible(true);
    }
}
