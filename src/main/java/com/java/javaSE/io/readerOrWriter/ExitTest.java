package com.java.javaSE.io.readerOrWriter;

import java.io.*;

public class ExitTest
{
    public static void main(String[] args) {

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\file\\acb9.txt");
            inputStreamReader = new InputStreamReader(System.in);
            outputStreamWriter = new OutputStreamWriter(System.out);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "";

        try {
            while (!str.equals("exit"))
            {
                str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
