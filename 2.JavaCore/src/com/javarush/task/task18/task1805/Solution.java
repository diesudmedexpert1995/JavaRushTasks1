package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(filename);
        TreeSet<Integer> sortBytesSet = new TreeSet<>();

        while (fis.available() > 0){
            sortBytesSet.add(fis.read());
        }
        fis.close();

        for (int value: sortBytesSet)  System.out.print(value + " ");
    }
}
