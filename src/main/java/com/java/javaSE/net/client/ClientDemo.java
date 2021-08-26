package com.java.javaSE.net.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客服端的套接字
        Socket socket = new Socket("127.0.0.1", 10086);
        //-----------------向外进行输出----------------------------

        //获取输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //数据输出
        outputStream.write("hello java".getBytes());


        //----------------接收服务端返回的消息------------------------
        InputStream inputStream = socket.getInputStream();
        //创建byte数组存储接收到的数据
        byte[] bytes = new byte[1024];
        //读取数据
        int read = inputStream.read(bytes);
        //打印服务端返回数据
        System.out.println("服务端的响应数据是："+new String(bytes,0,read));

        //关闭全部流
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
