package com.java.javaSE.io.readerOrWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest
{
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\file\\acb8.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("但实际上借记卡");
            bufferedWriter.write("马士兵教育");
            bufferedWriter.newLine();
            bufferedWriter.write("测试");
            bufferedWriter.write("2sdsdasd");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
