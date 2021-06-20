package com.java.company.tcp;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer
{
    public static void main(String[] args)
    {
        try {
            ServerSocket s = new ServerSocket(8888);
            while (true)
            {
                Socket socket = s.accept();
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF("Hello,"+socket.getInetAddress()+"port#"+socket.getPort()+" byte-byte!");
                dos.close();
                socket.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("程序运行出错:"+e);
        }
    }
}
