package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot implements Attackable, Defensable {

    public Robot(String name) {
        super(name);
    }

    public String getName() {
        return super.getName();
    }


}
