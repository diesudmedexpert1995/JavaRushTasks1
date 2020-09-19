package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(0.1, "Label1");
        labels.put(0.2, "Label2");
        labels.put(0.3, "Label3");
        labels.put(0.4, "Label4");
        labels.put(0.5, "Label5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
