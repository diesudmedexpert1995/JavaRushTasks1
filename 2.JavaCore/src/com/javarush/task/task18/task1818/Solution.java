package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = consoleReader.readLine();
        String filename2 = consoleReader.readLine();
        String filename3 = consoleReader.readLine();

        consoleReader.close();

        FileOutputStream fos1 = new FileOutputStream(filename1, true);
        FileInputStream fis1 = new FileInputStream(filename2);
        FileInputStream fis2 = new FileInputStream(filename3);

        while(fis1.available() > 0){
            byte[] buffer = new byte[fis1.available()];
            fis1.read(buffer);
            fos1.write(buffer);
        }
        fis1.close();

        while(fis2.available() > 0){
            byte[] buffer = new byte[fis2.available()];
            fis2.read(buffer);
            fos1.write(buffer);
        }
        fis2.close();
        fos1.close();
    }
}
