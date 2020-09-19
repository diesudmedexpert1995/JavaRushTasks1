package com.javarush.task.task12.task1216;

/* 
Летать охота
*/

public class Solution {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setName("Book1").setAuthor("Autho1");
    }

    //add an interface here - добавь интерфейс тут
    public interface CanFly {
        void fly();
        boolean isFlying();
    }

    public static class Book{
        private String name;
        private String author;

        public Book() {
        }

        public Book(String name, String author) {
            this.name = name;
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public Book setName(String name) {
            this.name = name;
            return this;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

}
