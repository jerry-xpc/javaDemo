package com.GUI;

import java.awt.*;

public class TestBorderLayout
{
    public static void main(String[] args) {
        Frame frame = new Frame("Border Layout");
        Button b1 = new Button("BN");
        Button b2 = new Button("BS");
        Button b3 = new Button("BW");
        Button b4 = new Button("BE");
        Button b5 = new Button("BC");

        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2,BorderLayout.SOUTH);
        frame.add(b3,BorderLayout.WEST);
        frame.add(b4,BorderLayout.EAST);
        frame.add(b5,BorderLayout.CENTER);

        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
