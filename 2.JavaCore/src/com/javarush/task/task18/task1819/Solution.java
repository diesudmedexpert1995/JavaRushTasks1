package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
         //Размер буффера для чтения
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        int BUF_SIZE = 1024;
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        fileToMem (mem, fileName2, BUF_SIZE);
        fileToMem (mem, fileName1, BUF_SIZE);
        FileOutputStream f = new FileOutputStream(fileName1);
        mem.writeTo(f);
        f.close();
    }

    public static void fileToMem(ByteArrayOutputStream mem, String fileName, int buffSize) throws IOException {
        FileInputStream f = new FileInputStream(fileName);
        int readedByte = 0;
        while (f.available() > 0) {
            byte[] buf = new byte[buffSize];
            readedByte = f.read(buf);
            mem.write(buf, 0, readedByte);
        }
        f.close();
    }
}
