package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Stack<Throwable> exceptionStack = new Stack<>();
        exceptionStack.push(e);
        Throwable throwable = e.getCause();
        while (throwable != null){
            exceptionStack.push(throwable);
            throwable = throwable.getCause();
        }
        while (!exceptionStack.empty()){
            Throwable current = exceptionStack.pop();
            System.out.println(current.getClass().getName()+": "+current.getMessage());
        }
    }

    public static void main(String[] args) {
    }
}
