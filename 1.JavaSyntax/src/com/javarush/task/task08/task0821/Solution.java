package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String,String> map = new HashMap<>();
        map.put("Фам1", "Иван");
        map.put("Фам2", "Олег");
        map.put("Фам3", "Петя");
        map.put("Фам1", "Антон");
        map.put("Фам5", "Иван");
        map.put("Фам6", "Костя");
        map.put("Фам7", "Петя");
        map.put("Фам8", "Антон");
        map.put("Фам2", "Сергей");
        map.put("Фам1", "Олег");
        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
