package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void checkProps(){
        System.out.println("Cheking properties");
    }

    public void checkConfig(){
        System.out.println("Cheking config");
    }
}
