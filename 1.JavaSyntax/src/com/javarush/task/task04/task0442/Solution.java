package com.javarush.task.task04.task0442;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true){

            int in = Integer.parseInt(reader.readLine());
            sum += in;
            if(in == (-1)){
                break;
            }
        }
        System.out.println(sum);

    }
}
