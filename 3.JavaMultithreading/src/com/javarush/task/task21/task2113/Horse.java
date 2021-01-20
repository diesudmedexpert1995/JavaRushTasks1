package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(){
        this.distance += this.speed*Math.random();
    }
    public void print(){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < (int)getDistance(); i++) {
            sb.append(".");
        }
        System.out.println(sb+getName());
    }
}
