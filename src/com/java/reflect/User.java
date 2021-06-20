package com.java.reflect;


import javax.jws.soap.SOAPBinding;

public class User {
    private String name = "init";
    private int age;

    public User(){}

    public User(String name,int age){
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("根据类名： \t" + User.class);
        System.out.println("根据对象： \t" + new User().getClass());
        System.out.println("根据全限定类名： \t" + Class.forName("com.java.reflect.User"));
        System.out.println("================================================================");
        Class<User> userClass = User.class;
        System.out.println("获取全限定类名： \t" + userClass.getName());
        System.out.println("获取类名： \t" + userClass.getSimpleName());
        System.out.println("实例化： \t" + userClass.newInstance());
    }
}
