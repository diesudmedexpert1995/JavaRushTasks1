package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0],"rw")){
            long number = Long.parseLong(args[1]);
            long size = randomAccessFile.length();
            number = (number > size)?size:number;
            randomAccessFile.seek(number);
            randomAccessFile.write(args[2].getBytes());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
