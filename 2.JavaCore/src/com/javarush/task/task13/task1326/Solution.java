package com.javarush.task.task13.task1326;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());

        Scanner sc = new Scanner(fis);
        ArrayList<Integer> numberList = new ArrayList<>();

        while (sc.hasNextInt())
        {
            int tmp = sc.nextInt();
            if (tmp % 2 == 0){
                numberList.add(tmp);
            }
        }
        fis.close();
        reader.close();
        Collections.sort(numberList);

        for (Integer i : numberList) {
            System.out.println(i);
        }

    }
}
