package com.java.javaSE.net.client;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -2916379416908115433L;

    private String userName;
    private String password;

    public User(){}

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
