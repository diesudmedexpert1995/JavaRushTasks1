package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<Horse>(Arrays.asList(new Horse[]{new Horse("Belka", 3.0, 0.0), new Horse("Strelka", 3.0, 0.0), new Horse("Burabai", 3.0, 0.0)})));
        game.run();
        game.printWinner();
    }

    public void move(){
        for (Horse horse: horses) {
            horse.move();
        }
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            try {
                move();
                print();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void print(){
        for (Horse horse: horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);
        double distance = horses.get(0).getDistance();
        for (Horse horse: horses) {
            if (horse.getDistance() >  distance){
                distance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
