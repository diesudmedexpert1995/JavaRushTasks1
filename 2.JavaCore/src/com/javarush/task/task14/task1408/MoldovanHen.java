package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    public String country = Country.MOLDOVA;
    @Override
    public int getCountOfEggsPerMonth() {
        //return ((int)Math.ceil(Math.random()*5))*30;
        return 25;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+ Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}