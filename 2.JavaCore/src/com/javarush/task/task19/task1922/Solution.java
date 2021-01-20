package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        consoleReader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(filename));

        while (bufferedFileReader.ready()){
            String contentLine = bufferedFileReader.readLine();
            String[] contentLineWords = contentLine.split("[\\p{P}\\s\\t\\n\\r]");
            int currentWordCount = 0;
            for (String wordFromLine: contentLineWords) {
                for (String wordFromList: words) {
                    if (wordFromLine.trim().equals(wordFromList)) currentWordCount++;
                }
            }
            if (currentWordCount == 2) System.out.println(contentLine);
        }
        bufferedFileReader.close();
    }
}
