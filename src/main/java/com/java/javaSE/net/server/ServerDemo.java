package com.java.javaSE.net.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建serverSocket对象
        ServerSocket serverSocket = new ServerSocket(10086);
        //获取服务端的套接字对象
        Socket accept = serverSocket.accept();

        //--------------------获取客户端传输数据--------------
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println("客户端传输的数据是："+new String(bytes,0,read));

        //------------------向客户端回应数据------------------
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("您好 已收到您的问候".getBytes());

        //关闭所有的流
        outputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
