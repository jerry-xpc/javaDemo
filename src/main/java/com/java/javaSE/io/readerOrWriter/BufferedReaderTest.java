package com.java.javaSE.io.readerOrWriter;

import java.io.*;

public class BufferedReaderTest
{
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\file\\abc.txt"));
            String read = null;
            while ((read = reader.readLine()) != null)
            {
                System.out.println(read);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
