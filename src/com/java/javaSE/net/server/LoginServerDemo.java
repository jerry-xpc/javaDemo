package com.java.javaSE.net.server;

import com.java.javaSE.net.client.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServerDemo {
    public static void main(String[] args) throws Exception {
        //创建serverSocket对象
        ServerSocket serverSocket = new ServerSocket(8080);
        //获取服务端socket对象
        Socket socket = serverSocket.accept();
        //获取客户端传输数据
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        //从对象输入流中获取到User对象
        User user = (User) objectInputStream.readObject();
        //响应客户端结果
        String str = null;
        if ("pwd".equals(user.getUserName()) && "pwd".equals(user.getPassword())){
            System.out.println("欢迎您！----"+user.getUserName());
            str = "登录成功!";
        }else{
            str = "登录失败，请重试！";
        }
        //读取客户端数据完成，关闭输入流
        socket.shutdownInput();

        //响应客户端回应结果创建输出流对象
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(str);

        //关闭全部流对象
        dataOutputStream.close();
        objectInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
