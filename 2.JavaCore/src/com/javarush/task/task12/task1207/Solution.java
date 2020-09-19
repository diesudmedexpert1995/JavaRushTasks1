package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(new Integer(12));
        print(12);
    }

    //Напишите тут ваши методы
    public static void print(Integer i) {
        System.out.println(i.toString());
    }

    public static void print(int i) {
        System.out.println(i);
    }
}
