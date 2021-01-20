package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String str = null;
        while (true) {
            try {
                str = consoleReader.readLine();
                break;
                } catch (IOException ex) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return str;
    }

    public static int readInt(){
        int result_int = 0;
        try {
            result_int = Integer.parseInt(readString());
        }catch (NumberFormatException ex){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            result_int = Integer.parseInt(readString());
        }
        return result_int;
    }
}
