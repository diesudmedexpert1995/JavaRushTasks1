package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = consoleReader.readLine();
        String filename2 = consoleReader.readLine();
        consoleReader.close();

        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);

        int i = 1;

        while (fileReader.ready()){
            int value = fileReader.read();
            if (i%2 == 0) fileWriter.write(value);
            i++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
