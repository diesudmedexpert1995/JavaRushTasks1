package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter printWriter = new BufferedWriter(new FileWriter(args[1]));

        while (fileReader.ready()){
            String line = fileReader.readLine();
            String[] words = line.split(" ");
            for (String word: words) {
                if (!word.matches("^\\D*$")){
                    printWriter.write(word+" ");
                }
            }
        }
        fileReader.close();
        printWriter.close();
    }
}
