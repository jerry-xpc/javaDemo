package com.javaSE.io.readerOrWriter;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderTest
{
    public static void main(String[] args){
        CharArrayReader charArrayReader = null;
        char[] chars = "马士兵教育".toCharArray();
        try {
            charArrayReader = new CharArrayReader(chars);
            int read = 0;
            while ((read = charArrayReader.read()) != -1)
            System.out.print((char) read);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            charArrayReader.close();
        }
    }
}
