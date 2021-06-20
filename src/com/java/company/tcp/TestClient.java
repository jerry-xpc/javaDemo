package com.company.tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TestClient
{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println(dataInputStream.readUTF());
            dataInputStream.close();
            socket.close();
        }
        catch (Exception e)
        {
            System.out.println("连接服务器失败!");
            e.printStackTrace();
        }
    }
}
