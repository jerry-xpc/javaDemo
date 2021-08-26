package com.java.company.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSockServer
{
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {

            ServerSocket serverSocket = new ServerSocket(5888);
            Socket socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            DataInputStream dos = new DataInputStream(inputStream);
            DataOutputStream dou = new DataOutputStream(outputStream);
            String s = null;
            if ((s = dos.readUTF()) != null)
            {
                System.out.println(s);
                System.out.println("from:" +socket.getInetAddress());
                System.out.println("Port:" + socket.getPort());
            }
            dou.writeUTF("hi, Hello");
            dou.close();
            dos.close();
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
