package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private char sex;
        private boolean hasEducation;
        private boolean isEmployee;
        private boolean isMarried;

        public Human() {
            this.name = "unknown";
            this.age = 1;
            this.sex = 'f';
            this.hasEducation = false;
            this.isEmployee = false;
            this.isMarried = false;
        }

        public Human(String name, char sex) {
            this.name = name;
            this.sex = sex;
            this.age = 1;
            this.hasEducation = false;
            this.isEmployee = false;
            this.isMarried = false;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
            this.sex = 'f';
            this.hasEducation = false;
            this.isEmployee = false;
            this.isMarried = false;
        }

        public Human(String name, int age, char sex, boolean hasEducation) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.hasEducation = hasEducation;
            this.isEmployee = false;
            this.isMarried = false;
        }

        public Human(String name, int age, char sex, boolean hasEducation, boolean isEmployee) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.hasEducation = hasEducation;
            this.isEmployee = isEmployee;
            this.isMarried = false;
        }

        public Human(int age, char sex, boolean hasEducation, boolean isEmployee, boolean isMarried) {
            this.name = "Unknown";
            this.age = age;
            this.sex = sex;
            this.hasEducation = hasEducation;
            this.isEmployee = isEmployee;
            this.isMarried = isMarried;
        }

        public Human( boolean hasEducation, boolean isEmployee, boolean isMarried) {
            this.name = "Unknown";
            this.age = 1;
            this.sex = 's';
            this.hasEducation = hasEducation;
            this.isEmployee = isEmployee;
            this.isMarried = isMarried;
        }

        public Human( boolean isEmployee, boolean isMarried) {
            this.name = "Unknown";
            this.age = 1;
            this.sex = 'f';
            this.hasEducation = false;
            this.isEmployee = isEmployee;
            this.isMarried = isMarried;
        }

        public Human(String name, boolean isEmployee, boolean isMarried) {
            this.name = name;
            this.age = 1;
            this.sex = 'f';
            this.hasEducation = false;
            this.isEmployee = isEmployee;
            this.isMarried = isMarried;
        }

        public Human(String name, int age, char sex, boolean hasEducation, boolean isEmployee, boolean isMarried) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.hasEducation = hasEducation;
            this.isEmployee = isEmployee;
            this.isMarried = isMarried;
        }
    }
}
