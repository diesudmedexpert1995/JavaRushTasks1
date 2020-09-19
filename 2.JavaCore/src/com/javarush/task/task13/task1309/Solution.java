package com.javarush.task.task13.task1309;

/* 
Всё, что движется
*/

public class Solution {
    public interface CanMove {
        Double speed();
    }

    public interface CanFly extends CanMove{

        Double speed(CanFly cf);
    }
    public static void main(String[] args) throws Exception {
    }
}