package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> family = new HashMap<>();

        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            String lastName = reader.readLine();
            if (lastName.isEmpty()){
                break;
            }

            family.put(city, lastName);
        }

        String familyInCityToFind = reader.readLine();

        for (Map.Entry<String, String> pair : family.entrySet()) {
            String city = pair.getKey();
            String lastName = pair.getValue();

            if (city.equals(familyInCityToFind))
                System.out.println(lastName);

        }
    }
}
