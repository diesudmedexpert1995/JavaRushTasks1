package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private Thread thread;
    public LoggingStateThread(Thread target){
        this.thread = target;
    }

    @Override
    public void run() {
        Thread.State currentState = thread.getState();
        System.out.println(currentState);
        super.run();
        while (!currentState.equals(State.TERMINATED)){
            Thread.State newState = thread.getState();
            if (!newState.equals(currentState)){
                System.out.println(newState);
                currentState = newState;
            }
        }
        this.interrupt();
    }
}
