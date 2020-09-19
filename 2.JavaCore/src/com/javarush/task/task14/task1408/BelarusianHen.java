package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    public String country = Country.BELARUS;
    @Override
    public int getCountOfEggsPerMonth() {
        //return ((int)Math.ceil(Math.random()*5))*30;
        return 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+ Country.BELARUS+". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";
    }

}