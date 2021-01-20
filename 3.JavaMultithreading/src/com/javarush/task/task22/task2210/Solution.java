package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/* 
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String query = "com.javarush.task22.task2210";
        String[] tokens = getTokens(query,".");
        for (String s: tokens) {
            System.out.println(s);
        }
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] tokens = new String[st.countTokens()];
        for (int i = 0; st.hasMoreElements(); i++) {
            tokens[i] = st.nextToken();
        }
        return tokens;
    }
}
