package com.javaSE.io.readerOrWriter;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;

public class CharArrayWriterTest
{
    public static void main(String[] args) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        charArrayWriter.write(97);
        charArrayWriter.write(98);
        charArrayWriter.write(99);
        System.out.print(charArrayWriter);
    }
}
