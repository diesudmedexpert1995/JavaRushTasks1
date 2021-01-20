package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if( telNumber == null || telNumber.isEmpty()) return false;
        return (telNumber.matches("^\\+[\\(\\-]?(\\d[\\(\\)\\-]?){11}\\d$") ||
                //ИЛИ один раз откр.скобочка, 9 раз цифры, 1 раз скобочки и - скобочки по одному разу и в конце 10-я цифра
                telNumber.matches("^\\(?(\\d[\\-\\(\\)]?){9}\\d$")) &&
                //И + один раз сколько угодно цифр, но если скобочка открыта в ней могут быть только 3 цифры, (ddd) 1 раз
                //сколько угодно цифр до знака - потом опять так потом сколько угодно цифр до последней цифры
                telNumber.matches("[\\+]?\\d*(\\(\\d{3}\\))?\\d*\\-?\\d*\\-?\\d*\\d$");
    }

    public static void main(String[] args) {

    }
}
