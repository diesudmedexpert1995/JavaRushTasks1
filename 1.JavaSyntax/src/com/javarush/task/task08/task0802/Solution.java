package com.javarush.task.task08.task0802;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Map из 10 пар
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Map<String, String> stringMap = new HashMap<String,String>();
        stringMap.put("арбуз","ягода");
        stringMap.put("банан","трава");
        stringMap.put("вишня","ягода");
        stringMap.put("груша", "фрукт");
        stringMap.put("дыня","овощ");
        stringMap.put("ежевика", "куст");
        stringMap.put("жень-шень", "корень");
        stringMap.put("земляника", "ягода");
        stringMap.put("ирис", "цветок");
        stringMap.put("картофель","клубень");

        Iterator<Map.Entry<String,String>> iterator = stringMap.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String,String> pair = iterator.next();
            System.out.println(pair.getKey() +" - "+ pair.getValue());
        }
    }
}
