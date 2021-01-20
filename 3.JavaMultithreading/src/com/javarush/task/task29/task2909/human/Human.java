package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected Size size;

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    private List<Human> children = new ArrayList<>();

        private BloodGroup bloodGroup;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live() {}

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + Size.height + " Вес: " + Size.weight);
    }

    public void addChild(Human child){
        children.add(child);
    }

    public void removeChild(Human child){
        if (children == null || children.isEmpty()){ return ;}
        children.remove(child);
    }

    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }

    public static class Size {
        public static int height;
        public static int weight;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}