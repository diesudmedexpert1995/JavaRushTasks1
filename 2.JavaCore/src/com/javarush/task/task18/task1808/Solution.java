package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFilename = reader.readLine();
        String outputFile1Name = reader.readLine();
        String outputFile2Name = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(inputFilename);
        FileOutputStream fileOutput1Stream = new FileOutputStream(outputFile1Name);
        FileOutputStream fileOutput2Stream = new FileOutputStream(outputFile2Name);

        int fileSize = fileInputStream.available();
        int firstPartSize = fileInputStream.available() % 2 == 0 ?fileInputStream.available() / 2: (fileInputStream.available() / 2) + 1;

        while (fileInputStream.available() > 0){
            byte[] buffer1 = new byte[firstPartSize];
            byte[] buffer2 = new byte[fileSize - firstPartSize];

            fileInputStream.read(buffer1);
            fileInputStream.read(buffer2);
            fileOutput1Stream.write(buffer1);
            fileOutput2Stream.write(buffer2);
        }
        fileInputStream.close();
        fileOutput1Stream.close();
        fileOutput2Stream.close();

    }
}
