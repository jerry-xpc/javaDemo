package com.java.javaSE.net.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            //创建socket对象，其实是开启实现io的虚拟接口（此接口不是java中的接口，而是类似于网线的卡槽），需要指定数据接收方的ip地址和端口
            Socket socket = new Socket("127.0.0.1",18880);
            //获取输出流对象，向服务端发送数据
            OutputStream outputStream = socket.getOutputStream();
            //将输出流对象进行包装
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            //传输数据
            dataOutputStream.writeUTF("hello 您好！");
            //关闭流
            dataOutputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
