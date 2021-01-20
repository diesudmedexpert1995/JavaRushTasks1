package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader =  new BufferedReader(new InputStreamReader(System.in));
        String filename1 = consoleReader.readLine();
        String filename2 = consoleReader.readLine();
        consoleReader.close();
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filename1));

        while (reader.ready()){
            lines.add(reader.readLine());
        }

        reader.close();

        ArrayList<Long> values = new ArrayList<Long>();

        for (String s: lines) {
            for (String part: s.split(" ")) {
                double a = Double.parseDouble(part);
                values.add(Math.round(a));
            }
        }
        reader.close();

        FileWriter fw = new FileWriter(filename2);

        for (Long value: values) {
            fw.write(value.toString() + " ");
        }
        fw.close();


    }
}
