package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> catMap = new HashMap<>();
        catMap.put("Cat0", new Cat("Cat0"));
        catMap.put("Cat1", new Cat("Cat1"));
        catMap.put("Cat2", new Cat("Cat2"));
        catMap.put("Cat3", new Cat("Cat3"));
        catMap.put("Cat4", new Cat("Cat4"));
        catMap.put("Cat5", new Cat("Cat5"));
        catMap.put("Cat6", new Cat("Cat6"));
        catMap.put("Cat7", new Cat("Cat7"));
        catMap.put("Cat8", new Cat("Cat8"));
        catMap.put("Cat9", new Cat("Cat9"));
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> catSet = new HashSet<>();
        catSet.addAll(map.values());
        return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
