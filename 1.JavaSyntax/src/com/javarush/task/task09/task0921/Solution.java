package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код

        ArrayList<Integer> numList = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                numList.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch (Exception ex){
            for (int i = 0; i < numList.size(); i++) {
                System.out.println(numList.get(i));
            }
        }
    }
}
