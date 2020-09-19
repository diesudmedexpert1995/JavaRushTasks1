package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
    }

    static class MyException extends OutOfMemoryError {
    }

    static class MyException2 extends LinkageError{
    }

    static class MyException3 extends IOException {
    }

    static class MyException4 extends FileNotFoundException {
    }
}

