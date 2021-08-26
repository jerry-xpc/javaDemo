package com.java.company.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSockClient
{
    public static void main(String[] args) {

        InputStream is = null;
        OutputStream out = null;
        try
        {
            Socket socket = new Socket("localhost",5888);
            is = socket.getInputStream();
            out = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(is);
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("hey");
            String s = null;
            if ((s = dis.readUTF()) != null)
            {
                System.out.println(s);
            }

            dos.close();
            dis.close();
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
