package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        double max = Double.MIN_VALUE;
        while (fileReader.ready()){
            String s = fileReader.readLine();
            String[] words = s.split("[\\s\\t\\n\\x0B\\f\\r]");
            String key = words[0];
            double value = Double.parseDouble(words[1]);
            if (map.containsKey(key)) map.put(key, map.get(words[0])+value);
            else map.put(key,value);
        }
        fileReader.close();

        for (Double value: map.values()) {
            if ( max < value) max = value;
        }

        for (Map.Entry<String, Double> pair: map.entrySet()) {
            if (pair.getValue().equals(max))
                System.out.println(pair.getKey());
        }

    }
}
