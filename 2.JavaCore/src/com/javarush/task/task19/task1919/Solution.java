package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedFileReader.ready()){
            String contentLine = bufferedFileReader.readLine();
            String[] parts = contentLine.split(" ");
            //new Solution().addToMap(parts[0], Double.parseDouble(parts[1]));
            if (!map.containsKey(parts[0])) map.put(parts[0], Double.parseDouble(parts[1]));
            else map.put(parts[0], map.get(parts[0])+Double.parseDouble(parts[1]));
        }

        bufferedFileReader.close();
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue()); // - Так проходит
        }
    }
}
