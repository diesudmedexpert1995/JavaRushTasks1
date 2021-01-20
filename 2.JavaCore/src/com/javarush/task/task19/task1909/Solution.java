package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = consoleReader.readLine();
        String fileName2 = consoleReader.readLine();
        consoleReader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileName2));

        while (bufferedFileReader.ready()){
            String contentLine = bufferedFileReader.readLine().replace(".","!");
            bufferedFileWriter.write(contentLine);
        }

        bufferedFileReader.close();
        bufferedFileWriter.close();
    }
}
