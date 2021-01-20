package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(filename);
        int minByte = fis.read();

        while (fis.available()-1 > 0){
            int currentByte = fis.read();
            if (currentByte < minByte){
                minByte = currentByte;
            }
        }
        fis.close();
        System.out.println(minByte);
    }
}
