package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream component;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        component = fileOutputStream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException {
        this.component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.component.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        this.component.flush();
    }

    @Override
    public void close() throws IOException {
        this.component.flush();
        write("JavaRush © All rights reserved.".getBytes());
        this.component.close();
    }

    @Override
    public FileChannel getChannel() {
        return this.component.getChannel();
    }
}
