package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArray = reader.readLine().replace(" ","").toCharArray();
        String vowels = "";
        String notVowelsWithCommasDots = "";
        for (int i = 0; i < inputArray.length; i++) {
            if (isVowel(inputArray[i])){
                vowels+=inputArray[i]+" ";
            }
            else{
                notVowelsWithCommasDots+=inputArray[i]+" ";
            }
        }
        System.out.println(vowels);
        System.out.println(notVowelsWithCommasDots);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}