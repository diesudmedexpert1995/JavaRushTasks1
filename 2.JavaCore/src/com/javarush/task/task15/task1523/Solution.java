package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    int anInt = 0;
    short aShort = 0;
    double aDouble = 0.0;
    public Solution(int anInt){ this.anInt = anInt;}

    Solution(short aShort){
        this.aShort = aShort;
    }

    protected Solution(double aDouble){
        this.aDouble = aDouble;
    }
    private Solution(){}

    public static void main(String[] args) {

    }
}

