package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] keys = new byte[]{1,2,3,4,5};
        switch (args[0]){
            case "-e": {
                FileInputStream source = new FileInputStream(args[1]);
                FileOutputStream destination = new FileOutputStream(args[2]);
                while (source.available() > 0){
                    byte[] buffer = new byte[source.available()];
                    source.read(buffer);
                    int x =0;
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i] = (byte) (buffer[i] ^ keys[x]);
                        if (x > buffer.length){
                            x = 0;
                        }
                    }
                    destination.write(buffer);
                }
                source.close();
                destination.close();
                break;
                }
            case "-d":{
                FileInputStream source = new FileInputStream(args[1]);
                FileOutputStream destination = new FileOutputStream(args[2]);
                while (source.available() > 0){
                    byte[] buffer = new byte[source.available()];
                    source.read(buffer);
                    int x =0;
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i] = (byte) (buffer[i] ^ keys[x]);
                        if (x > buffer.length){
                            x = 0;
                        }
                    }
                    destination.write(buffer);
                }
                source.close();
                destination.close();
                break;
            }

        }

    }

}
