package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            list.add(i, reader.readLine());
        }

        for (int i = 0; i < M; i++) {
            String str = list.remove(i);
            list.add(str);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i));
        }

    }
}
