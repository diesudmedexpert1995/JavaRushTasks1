package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = consoleReader.readLine();
        String filename2 = consoleReader.readLine();
        consoleReader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename2));
        while (bufferedReader.ready()){
            String s = bufferedReader.readLine();
            String[] digital = s.split("\\s");
            for (String digit : digital) {
                try {
                    Integer value = Integer.parseInt(digit);
                    bufferedWriter.write(value+" ");
                }catch (NumberFormatException nfe){
                    continue;
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
