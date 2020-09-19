
package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<String> sl = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        sl.add("user");
        sl.add("loser");
        sl.add("coder");
        sl.add("proger");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;


        while (true) {
            String s = reader.readLine();
            int check = sl.size();

            for (int i = 0; i < sl.size(); i++) {
                if (s.equals(sl.get(i))) {
                    check = 1;
                    list.add(s);
                    break;
                } else {
                    check = 0;
                }
            }
            if (check == 0) {
                System.out.println("close reader!");
                reader.close();
                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("user")) {
                Person user = new Person.User();
                doWork(user);
            } else if (list.get(i).equals("loser")) {
                Person loser = new Person.Loser();
                doWork(loser);
            } else if (list.get(i).equals("coder")) {
                Person coder = new Person.Coder();
                doWork(coder);
            } else if (list.get(i).equals("proger")) {
                Person proger = new Person.Proger();
                doWork(proger);
            }
        }


    }


    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            Person.User user = (Person.User) person;
            user.live();
        } else if (person instanceof Person.Loser) {
            Person.Loser loser = (Person.Loser) person;
            loser.doNothing();
        } else if (person instanceof Person.Coder) {
            Person.Coder coder = (Person.Coder) person;
            coder.writeCode();
        } else if (person instanceof Person.Proger) {
            Person.Proger proger = (Person.Proger) person;
            proger.enjoy();
        }

    }
}