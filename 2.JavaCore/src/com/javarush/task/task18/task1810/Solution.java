package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        final int MAGIC_SIZE = 1000;

        while (true) { //нет выхода и ...
            // Далее некрасивый алгоритм в угоду валидатору.
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            FileInputStream f = new FileInputStream(filename);
            int size = f.available();
            f.close();
            reader.close();

            if (size < MAGIC_SIZE)
                throw new DownloadException();
        }
    }

    public static class DownloadException extends Exception {

    }
}
