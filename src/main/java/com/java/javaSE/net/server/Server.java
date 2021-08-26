package com.java.javaSE.net.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //服务端需要使用serverSocket来开启本地端口
            ServerSocket serverSocket = new ServerSocket(18880);
            //需要接收client传输过来的数据，需要定义socket对象
            Socket accept = serverSocket.accept();
            //通过server获取输入对象流
            InputStream inputStream = accept.getInputStream();
            //进行数据包装
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            //读取对应的数据
            String s = dataInputStream.readUTF();
            //打印客户端传输数据
            System.out.println(s);
            //关闭所有的流操作
            dataInputStream.close();
            inputStream.close();
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
