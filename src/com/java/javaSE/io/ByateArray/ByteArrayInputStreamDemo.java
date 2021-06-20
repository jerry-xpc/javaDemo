package com.javaSE.io.ByateArray;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteArrayInputStreamDemo
{
    public static void main(String[] args)
    {
        String str = "www.gjfax.com";
        ByteArrayInputStream byteArrayInputStream = null;
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byteArrayInputStream = new ByteArrayInputStream(bytes);
        int read = 0;
        while ((read = byteArrayInputStream.read()) != -1)
        {
            //跳跃输出
            byteArrayInputStream.skip(4);
            System.out.print((char) read);
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
