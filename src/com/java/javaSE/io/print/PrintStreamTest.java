package com.java.javaSE.io.print;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamTest
{
    public static void main(String[] args) {
        PrintStream printStream = null;

        try {
            printStream = new PrintStream(new FileOutputStream("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\file\\abc2.txt"));
            printStream.write("Hello Word mashibing".getBytes(StandardCharsets.UTF_8));
            printStream.println(true);
            System.out.println();
            //格式输出 %s:字符串 %d:整数 %f:浮点
            System.out.printf("%s--%d--%.2f","dssdadad",533,366.151551);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            printStream.close();
        }
    }
}
