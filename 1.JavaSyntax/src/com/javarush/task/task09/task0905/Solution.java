package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) {
        int deep = getStackTraceDepth();
    }

    public static int getStackTraceDepth() {
        //напишите тут ваш код
        int stackTraceLength = Thread.currentThread().getStackTrace().length;
        System.out.println(stackTraceLength);
        return stackTraceLength;
    }
}

