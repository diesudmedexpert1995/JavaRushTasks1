package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/
//"[\\p{Punct}\\n]",""
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = consoleReader.readLine();
        String filename2 = consoleReader.readLine();
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename2));

        while (fileReader.ready()){
            String contentLine = fileReader.readLine().replaceAll("[\\p{Punct}\\n]","");
            fileWriter.write(contentLine);
        }

        fileReader.close();
        fileWriter.close();

    }
}
