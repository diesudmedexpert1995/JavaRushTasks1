package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как-то средненько
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());

        if(num1 == num2 && num2 == num3 && num3 == num1){
            System.out.println(num1);
        }

        if(num1 != num2 && num2 != num3){
            System.out.println(num2);
        }

        if(num2 != num3 && num3 != num1){
            System.out.println(num3);
        }

        if((num2 != num1) && (num1 != num3)){
            System.out.println(num1);
        }
    }
}
