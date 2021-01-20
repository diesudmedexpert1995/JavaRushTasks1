package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        final double mediana;
        int middle = array.length / 2;
        Arrays.sort(array);
        if(array.length % 2 != 0){
            mediana = array[middle];
        } else {
            mediana = (array[middle-1] + array[middle])/2.0;
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                double result = Math.abs(integer1- mediana) - Math.abs(integer2 - mediana);
                return result == 0 ? integer1-integer2 : (int) Math.round(result);
            }
        });
        return array;
    }
}
