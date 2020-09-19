package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Тюленин", "Владимир");
        map.put("Фурсенко", "Андрей");
        map.put("Фурсенко ", "Сергей");
        map.put("Якунин", "Владимир");
        map.put("Пожарский ", "Дмитрий");
        map.put("Плахотнюк", "Николай");
        map.put("Гушан", "Виктор");
        map.put("Смирнов", "Владимир");
        map.put("Ковальчук", "Юрий");
        map.put("Мячин", "Алексей");
        map.put("Мячин", "Виктор");
        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int nameCounter =0;
        for (String s: map.values()) {
            if (s.equals(name)) nameCounter++;
        }
        return nameCounter;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int lastNameCounter = 0;
        for (Map.Entry<String,String> entry: map.entrySet()) {
            if(entry.getKey().equals(lastName)) lastNameCounter++;
        }
        return lastNameCounter;
    }

    public static void main(String[] args) {

    }
}
