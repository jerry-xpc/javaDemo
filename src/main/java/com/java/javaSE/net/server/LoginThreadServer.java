package com.java.javaSE.net.server;

import com.java.javaSE.net.client.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class LoginThreadServer implements Runnable{

    private Socket socket;

    public LoginThreadServer(){}

    public LoginThreadServer(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        DataOutputStream dataOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) objectInputStream.readObject();
            String str = null;
            if ("xingpc001".equals(user.getUserName()) && "password".equals(user.getPassword())){
                System.out.println("恭喜您登录成功！---"+user.getUserName());
                str = user.getUserName()+"恭喜您登录成功!";
            }else{
                str = user.getUserName()+"不好意思，登录失败，请重试!";
            }
            socket.shutdownInput();

            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(str);
            socket.shutdownOutput();

            dataOutputStream.close();
            objectInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                dataOutputStream.close();
                objectInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
