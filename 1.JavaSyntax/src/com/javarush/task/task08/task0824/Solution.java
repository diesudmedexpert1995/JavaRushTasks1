package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human ded = new Human("Ded #1", 70, true);
        Human ded2 = new Human("Ded #2", 72, true);
        Human babushka = new Human("Babushka #1", 65, false);
        Human babushka2 = new Human("Babushka #2", 67, false);
        Human father = new Human("Father", 50, true);
        Human mother = new Human("Mother", 40, false);
        Human boy = new Human("Boy #1", 15, true);
        Human boy2 = new Human("Boy #2", 13, true);
        Human girl = new Human("Girl", 10, false);
        ded.children.add(father);
        babushka.children.add(father);
        ded2.children.add(mother);
        babushka2.children.add(mother);
        father.children.add(boy);
        father.children.add(boy2);
        father.children.add(girl);
        mother.children.add(boy);
        mother.children.add(boy2);
        mother.children.add(girl);
        System.out.println(ded.toString());
        System.out.println(babushka.toString());
        System.out.println(ded2.toString());
        System.out.println(babushka2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(boy.toString());
        System.out.println(boy2.toString());
        System.out.println(girl.toString());
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children = new ArrayList<>();

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
