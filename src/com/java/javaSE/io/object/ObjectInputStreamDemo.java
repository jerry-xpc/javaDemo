package com.javaSE.io.object;

import com.javaSE.io.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo
{
    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\acb7.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println(objectInputStream.readUTF());
            try {
                Object object = objectInputStream.readObject();
                if (object instanceof Person)
                {
                    Person p = (Person) object;
                    System.out.println(p);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
