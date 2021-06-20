package com.GUI;

import javafx.scene.layout.Background;

import java.awt.*;

public class TestButtons
{
    public static void main(String[] args) {
        Frame frame = new Frame("Java Frame");

        frame.setLayout(new GridLayout(2,1));
        frame.setLocation(300,400);
        frame.setSize(300,400);
        frame.setBackground(new Color(204,204,255));
        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new BorderLayout());
        Panel p11 = new Panel(new GridLayout(2,1));
        Panel p21 = new Panel(new GridLayout(2,2));
        p1.add(new Button("Button1"),BorderLayout.WEST);
        p1.add(new Button("Button2"),BorderLayout.EAST);
        p11.add(new Button("Button3"));
        p11.add(new Button("Button4"));
        p1.add(p11,BorderLayout.CENTER);
        p2.add(new Button("Button5"),BorderLayout.WEST);
        p2.add(new Button("Button6"),BorderLayout.EAST);
        for (int i=1;i<=5;i++)
        {
            p21.add(new Button("Button"+i));
        }
        p2.add(p21,BorderLayout.CENTER);
        frame.add(p1);
        frame.add(p2);
        frame.setVisible(true);
    }
}
