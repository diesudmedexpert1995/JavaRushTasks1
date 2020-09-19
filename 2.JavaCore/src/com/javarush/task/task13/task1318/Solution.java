package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0){
            System.out.write(fis.read());
        }
        System.out.println();
        fis.close();
        bufferedReader.close();

    }
}