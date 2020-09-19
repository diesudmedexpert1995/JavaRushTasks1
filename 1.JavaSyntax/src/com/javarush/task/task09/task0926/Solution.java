package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        int[] firstElement = {8,2,3,5,9}, secondElement = {1,10}, thirdElement = {11, 9, 0 ,-6}, fourthElement = {-7, 12, 22, 9, 3, 2, 11}, fifthElement = {};
        ArrayList<int[]> intArrList = new ArrayList<int[]>(5);
        intArrList.add(firstElement);
        intArrList.add(secondElement);
        intArrList.add(thirdElement);
        intArrList.add(fourthElement);
        intArrList.add(fifthElement);

        return intArrList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
