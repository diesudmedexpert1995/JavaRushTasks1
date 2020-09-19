package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String,String> map = new HashMap<>();
        map.put("Фам1", "Иван");
        map.put("Фам2", "Олег");
        map.put("Фам3", "Петя");
        map.put("Фам4", "Антон");
        map.put("Фам5", "Иван");
        map.put("Фам6", "Костя");
        map.put("Фам7", "Петя");
        map.put("Фам8", "Антон");
        map.put("Фам9", "Сергей");
        map.put("Фам10", "Олег");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        List<String> lst = new ArrayList<>();

        for (Map.Entry<String, String> pair: map.entrySet()) {
            if (Collections.frequency(map.values(), pair.getValue())>1){
                lst.add(pair.getValue());
            }
        }
        for (String elem: lst) {
            removeItemFromMapByValue(map,elem);
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
