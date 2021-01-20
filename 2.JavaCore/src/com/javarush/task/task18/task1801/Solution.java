package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(filename);
        int maxByte = fis.read();

        while (fis.available()-1 > 0){
            int currentByte = fis.read();
            if (currentByte > maxByte){
                maxByte = currentByte;
            }
        }
        fis.close();
        System.out.println(maxByte);
    }
}
