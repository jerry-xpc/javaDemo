package com.java.javaSE.net.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        //创建服务端UDP套接字对象与指定端口
        DatagramSocket datagramSocket = new DatagramSocket(1001);
        //创建byte数组接收数据
        byte[] bytes = new byte[1024];
        //创建数据对象
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);
        //接收数据包对象
        datagramSocket.receive(datagramPacket);
        //打印接收到的数据
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        //关闭流
        datagramSocket.close();
    }
}
