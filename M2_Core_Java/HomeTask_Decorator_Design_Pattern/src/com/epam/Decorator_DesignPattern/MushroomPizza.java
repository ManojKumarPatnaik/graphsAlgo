package com.epam.Decorator_DesignPattern;

public class MushroomPizza implements Pizza{
    @Override
    public void getPizza(){
        System.out.print("your Order is Mushroom Pizza");
    }
}
