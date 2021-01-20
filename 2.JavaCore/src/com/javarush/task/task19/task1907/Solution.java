package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        int count =0;
        String matcher = "world";
        while (fileReader.ready()){
            String string = fileReader.readLine();
            String[] words = string.toString().split("\\W");
            for (String word: words) {
                if (word.equals(matcher)) count++;
            }
        }

        fileReader.close();
        System.out.println(count);

    }
}
