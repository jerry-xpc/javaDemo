package com.java.GUI;

import java.awt.*;

public class TestFrame
{
    public static void main(String[] args) {
        Frame f = new Frame("My First Test");
        //设置窗口坐标位置
        f.setLocation(300,300);
        //设置窗口宽高尺寸，像素
        f.setSize(370,380);
        //设置背景颜色
        f.setBackground(Color.BLUE);
        //是否可编辑
        f.setResizable(false);
        //设置是否可见
        f.setVisible(true);
    }
}
