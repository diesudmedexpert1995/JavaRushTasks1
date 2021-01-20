package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        consoleReader.close();
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        while (bufferedFileReader.ready()){
            sb.append(bufferedFileReader.readLine()+" ");
        }
        bufferedFileReader.close();
        String[] words = sb.toString().trim().split(" ");

        HashSet<Integer> integerHashSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if (integerHashSet.contains(i)) continue;
            for (int j = i+1; j < words.length; j++) {
                String current = new StringBuilder(words[j]).reverse().toString();
                if (current.equals(words[i])){
                    Pair pair = new Pair();
                    pair.first = current;
                    pair.second = words[j];
                    result.add(pair);
                    integerHashSet.add(j);
                    break;
                }
            }
        }
        for (Pair pair: result){
            System.out.println(pair);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
