package com.javarush.task.task14.task1421;

public class Singleton {
    private static Singleton instance;
    private Singleton(){
        instance = new Singleton();
    }


    public static Singleton getInstance(){
        return Singleton.instance;
    }
}
