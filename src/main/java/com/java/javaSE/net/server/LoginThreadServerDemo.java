package com.java.javaSE.net.server;

import com.java.javaSE.net.client.User;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginThreadServerDemo {
    public static void main(String[] args) throws Exception {
        //创建serverSocket对象
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            //获取服务端socket对象
            Socket socket = serverSocket.accept();
            LoginThreadServer loginThreadServer = new LoginThreadServer(socket);
            Thread thread = new Thread(loginThreadServer);
            thread.start();
        }
    }
}
