package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))){
            while (fileReader.ready()){
                String contentLine = fileReader.readLine();
                String nameString = contentLine.replaceAll("[\\w]","").trim();
                String[] digitals = contentLine.substring(nameString.length()).trim().split(" ");
                int day = Integer.parseInt(digitals[0]);
                int month = Integer.parseInt(digitals[1]);
                int year = Integer.parseInt(digitals[2]);
                Date date = new GregorianCalendar(year, month-1, day).getTime();
                PEOPLE.add(new Person(nameString,date));

            }
        }

    }
}
