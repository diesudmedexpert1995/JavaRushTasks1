package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    public Tablet getTablet() {
        return tablet;
    }

    private final Tablet tablet;

    protected List<Dish> dishes;

    public Order(Tablet tablet) {
        this.tablet = tablet;
        try {
            this.dishes = ConsoleHelper.getAllDishesForOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime(){
        int totalCookingTime = 0;
        for ( Dish dish: dishes) {
            totalCookingTime += dish.getDuration();
        }
        return totalCookingTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dishes.size() == 0) return sb.toString();
        sb.append("Your order: [");
        for (Dish dish: dishes) {
            sb.append(dish);
            sb.append(", ");
        }
        sb.append("] of "+tablet.toString());
        sb.append("cooking time ");
        sb.append(String.valueOf(getTotalCookingTime()));
        sb.append("min");
        return sb.toString();
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }
    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
