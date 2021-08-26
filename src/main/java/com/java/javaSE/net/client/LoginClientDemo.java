package com.java.javaSE.net.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端套接字socket
        Socket socket = new Socket("localhost", 8080);
        //获取输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //将输出流对象封装到object输出流对象中，方便传输对象参数
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        //将user对象写入服务端接收
        objectOutputStream.writeObject(new User("pwd1","pwd"));
        //输出流完成且关闭
        socket.shutdownOutput();
        //获取服务端写入数据
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String stf = dataInputStream.readUTF();
        System.out.println(stf);

        //关闭全部流
        dataInputStream.close();
        objectOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
