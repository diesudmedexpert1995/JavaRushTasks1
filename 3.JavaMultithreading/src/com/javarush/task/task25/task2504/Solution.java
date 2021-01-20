package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread th: threads) {
            switch (th.getState()){
                case NEW : th.start();break;
                case WAITING : th.interrupt(); break;
                case TIMED_WAITING : th.interrupt();break;
                case BLOCKED: th.interrupt(); break;
                case RUNNABLE : th.isInterrupted();break;
                case TERMINATED : System.out.println(th.getPriority());
            }
        }
    }

    public static void main(String[] args) {
        //processThreads(new Thread[]{ new Thread(), new Thread(), new Thread()});
    }
}
