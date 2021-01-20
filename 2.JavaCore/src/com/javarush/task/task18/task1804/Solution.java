package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        HashMap<Integer, Integer> mapOfByte = new HashMap<>();
        FileInputStream fis = new FileInputStream(filename);

        int value = 0;
        Integer count = 0;

        while (fis.available() > 0){
            value = fis.read();
            count = mapOfByte.get(value);
            if ( count != null) count++;
            else count = 0;
            mapOfByte.put(value, count);
        }
        fis.close();

        boolean isFirst = true;
        int min =0;
        for (int amountOfByte: mapOfByte.values()) {
            if (isFirst){
                min = amountOfByte;
                isFirst = false;
            }
            if (min > amountOfByte){
                min = amountOfByte;
            }
        }

        for (Map.Entry pair: mapOfByte.entrySet()) {
            if (min == (int)pair.getValue()){
                System.out.print(" " + pair.getKey());
            }
        }
    }
}
