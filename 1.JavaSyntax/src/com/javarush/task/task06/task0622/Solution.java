package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int[] arrToSort = new int[5];
        int i = 0;
        while (i < arrToSort.length){
            arrToSort[i]= Integer.parseInt(reader.readLine());
            i++;
        }

        for (i=0; i < arrToSort.length; i++){
            int min = arrToSort[i];
            int minIndex = i;
            for (int j = i + 1; j < arrToSort.length; j++){
                if (arrToSort[j] < min){
                    min = arrToSort[j];
                    minIndex = j;
                }
            }
            if (i != minIndex){
                int temp = arrToSort[i];
                arrToSort[i] = arrToSort[minIndex];
                arrToSort[minIndex] = temp;
            }
        }

        for (i = 0; i< arrToSort.length; i++){
            System.out.println(arrToSort[i]);
        }
    }
}
