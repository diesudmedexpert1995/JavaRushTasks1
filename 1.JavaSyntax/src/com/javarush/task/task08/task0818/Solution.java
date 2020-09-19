package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();

        map.put("Selezniov", 1200);
        map.put("Leoranskiy", 15000);
        map.put("Juvelinis", 1100);
        map.put("Semionov", 3900);
        map.put("Kolian", 1890);
        map.put("Bomzhov", 120);
        map.put("Ravin", 300);
        map.put("Batutin", 1000);
        map.put("Nikolaev", 400);
        map.put("Antonov", 11200);

        return map;

    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Map<String, Integer> copy = new HashMap<>(map);

        for (Map.Entry<String, Integer> pair: copy.entrySet()) {
            if (pair.getValue() < 500){
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}