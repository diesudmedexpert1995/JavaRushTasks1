package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт Ӏ Java Syntax: 7 уровень, 12 лекция
*/

public class Solution {
    public static void main(String[] args) {
        try {
            for (int i = 30; i >= 0; i--) {
                System.out.println(i);

                //напишите тут ваш код
                Thread.sleep(100);
            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("Бум!");
    }
}
