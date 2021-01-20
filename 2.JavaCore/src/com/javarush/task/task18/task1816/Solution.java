package com.javarush.task.task18.task1816;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = alphabet.toUpperCase();

        FileReader fileReader = new FileReader(args[0]);

        int count = 0;
        while(fileReader.ready()){
            char ch = (char) fileReader.read();
            if (alphabet.indexOf(ch) > -1 || alphabetUpperCase.indexOf(ch) > -1) count++;
        }
        fileReader.close();

        System.out.println(count);
    }
}
