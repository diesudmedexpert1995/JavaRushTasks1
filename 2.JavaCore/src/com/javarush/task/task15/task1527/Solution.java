package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String params = s.substring(s.indexOf("?")+1);
        String[] splitParts;
        splitParts = params.split("&");

        LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();

        for (int i = 0; i < splitParts.length; i++) {
            int posEqualsChar = splitParts[i].indexOf("=");
            if (posEqualsChar < 0){
                parameters.put(splitParts[i], null);
                continue;
            }
            String key = splitParts[i].substring(0,posEqualsChar);
            String value = splitParts[i].substring(posEqualsChar+1);
            parameters.put(key,value);
        }
        for (String key: parameters.keySet()) {
            System.out.println(key + " ");
        }

        System.out.println();
        String objParameter = parameters.get("obj");
        if (objParameter == null){
            return;
        }
        try {
            alert(Double.parseDouble(objParameter));
        }catch (NumberFormatException nfe){
            alert(objParameter);
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
