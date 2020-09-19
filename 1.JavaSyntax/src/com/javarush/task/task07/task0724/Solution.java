package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandfather1 = new Human("Иван", true, 60);
        Human grandfather2 = new Human("Петр", true, 65);
        Human grandmother1 = new Human("Ольга", false, 57);
        Human grandmother2 = new Human("Елизавета", false, 60);

        Human father = new Human("Владимир", true, 40, grandfather1, grandmother1);
        Human mother = new Human("Наталия", false, 38, grandfather2, grandmother2);

        Human son = new Human("Сергей", true, 16, father, mother);
        Human daughter1 = new Human("Лилия", false, 14, father, mother);
        Human daughter2 = new Human("Янина", false, 18, father, mother);

        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter1);
        System.out.println(daughter2);
    }

    public static class Human {
        // напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}