package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Byte, Integer> frequencyMap = new TreeMap<Byte, Integer>();

        FileInputStream fis = new FileInputStream(args[0]);

        while(fis.available() > 0){
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                if (frequencyMap.containsKey(buffer[i])) frequencyMap.put(buffer[i], frequencyMap.get(buffer[i])+1);
                else frequencyMap.put(buffer[i], 1);
            }
        }
        fis.close();
        for (Map.Entry pair : frequencyMap.entrySet()) {
            System.out.println((char)((byte) pair.getKey()) + " " + pair.getValue());
        }
    }
}
