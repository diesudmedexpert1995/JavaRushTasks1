package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = null;

        while (true){
            String filename = consoleReader.readLine();
            try {
              file = new FileInputStream(filename);
              file.close();
            } catch (FileNotFoundException ex){
                System.out.println(filename);
                consoleReader.close();
                return;
            }
        }
    }
}
