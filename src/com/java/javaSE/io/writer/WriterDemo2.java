package com.javaSE.io.writer;

import java.io.*;

public class WriterDemo2
{
    public static void main(String[] args)
    {
        Reader reader = null;
        Writer writer = null;

        try {
            File file = new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\abc.txt");
            File file1 = new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\acb3.txt");

            reader = new FileReader(file);
            writer = new FileWriter(file1);
            char[] chars = new char[1024];
            int length = 0;
            while ((length = reader.read(chars)) != -1)
            {
                writer.write(chars,0,length);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                writer.close();
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
