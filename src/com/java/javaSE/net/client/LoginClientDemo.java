package com.java.javaSE.net.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(new User("pwd","pwd"));
    }
}
