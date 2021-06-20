package com.javaSE.io.readerOrWriter;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DaiDuTest
{
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://www.baidu.com").openStream(),"utf-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.txt")));

            String sms = null;
            while ((sms = bufferedReader.readLine()) != null)
            {
                bufferedWriter.write(sms);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
