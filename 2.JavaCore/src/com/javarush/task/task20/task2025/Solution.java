package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        if (N < 1){
            long[] result = {0L};
            return result;
        }
        if (N < 2){
            long[] result = {N};
            return result;
        }
        ArrayList<Long> sam = new ArrayList<>();
        if (Long.MAX_VALUE >= N) {
            ArrayList<Integer> listN = new ArrayList<>();
            Set<Long> resultList = new HashSet<>();

            long n = N; // все пров числа меньше N
            while (n >= 1) { //заполняем лист через дел на 10 и пол остатка
                n /= 10;
                listN.add(9);
            }
            //Collections.sort(listN);
            //System.out.println(listN.toString());
            long[][] arr = new long[10][listN.size()];// массив 0-9 и степени от 1 - listN.size()
            for (int i = 0; i < 10; i++) {
                long num = i;
                for (int j = 0; j < listN.size(); j++) {              //arr[i][j] = (long) Math.pow(i, j + 1);
                    if (j == 0) arr[i][j] = i;
                    if (j > 0) {
                        arr[i][j] = i * num;
                        num = arr[i][j];
                    }
                }
            }

            long sumListNNum = 0L;
            long sumListNNumNull = 0L;
            int nullCunt;
            while (listN.get(listN.size() - 1) > 0) { //если последний элем мас чисел бол 0 то продолжаем
                nullCunt = 0;
                for (int i = 0; i < listN.size(); i++) {// проходем по массиву чисел из числа N
                    if (listN.get(i) == 0) {
                        nullCunt ++;
                        for (int j = i + 1; j < listN.size(); j++) {

                            // Примечание: исходные числовые последовательности с лидирующими нулями следует проверять несколько раз, отбрасывая
                            //перед каждой следующей проверкой один ноль от начала последовательности.
                            //Например, последовательность { 0, 0, 1, 2, 3 } может соответствовать таким числам: 132, 12300, 2301, 1032 и т. д.

                            sumListNNumNull += arr[listN.get(j)][listN.size() - 1 - nullCunt];
                            if (sumListNNumNull >= N || sumListNNumNull < 0) {
                                sumListNNumNull = 0;
                                break;
                            }
                        }
                        if (sumListNNumNull > 0) {
                            if (isArmstrongNum(sumListNNumNull, arr)) resultList.add(sumListNNumNull);

                        }

                        sumListNNumNull = 0;
                    }
                    sumListNNum += arr[listN.get(i)][listN.size() - 1];// сумируем числа возвед в степень берем их из двумерного массива


                    if (sumListNNum >= N || sumListNNum < 0) {     //проверка чо число меньше N
                        sumListNNum = 0;
                        break;
                    }
                }

                if (sumListNNum > 0) {       //если больше 0 может оно Армстронга??

                    if (isArmstrongNum(sumListNNum, arr)) resultList.add(sumListNNum);
                }
                sumListNNum = 0;
                listN.set(0, (listN.get(0) - 1));
                if (listN.get(0) < 0) {
                    int num;
                    for (int i = listN.size() - 1; i > -1; i--) {
                        if (listN.get(i) <= 0 && i < listN.size() - 1) {
                            num = listN.get(i + 1) - 1;
                            listN.set(i + 1, num);
                            while (i > -1) {
                                listN.set(i, num);
                                i--;
                            }
                        }
                    }
                }
            }
            sam.addAll(resultList);
            Collections.sort(sam);
        }

        long[] result = new long[sam.size()];
        for (int i = 0; i < sam.size(); i ++) result[i] = sam.get(i);
        return result;
    }

    public static boolean isArmstrongNum (long n, long arr[][]){
        long n2 = n;
        String s = String.valueOf(n);
        long numResult = 0L;
        while (n2 >= 1) {  //
            long num = n2 % 10;
            n2 /= 10;
            numResult += arr[(int) num][s.length() - 1];
        }
        return numResult == n;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
