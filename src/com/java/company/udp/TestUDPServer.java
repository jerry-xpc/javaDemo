package com.company.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPServer
{
    public static void main(String[] args)throws Exception {
        byte b[] = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b,b.length);
        DatagramSocket ds = new DatagramSocket(5678);

        while (true)
        {
            ds.receive(dp);
            //System.out.println(new String(b,0,dp.getLength()));

            ByteArrayInputStream bai = new ByteArrayInputStream(b);
            DataInputStream dis = new DataInputStream(bai);
            System.out.println(dis.readLong());
        }
    }
}
