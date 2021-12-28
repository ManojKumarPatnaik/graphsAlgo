package com.epam.Decorator_DesignPattern;

public class ChickenPizza implements Pizza{
    public  ChickenPizza(){
        
    }
    public  ChickenPizza(ChickenPizza che){

    }
    @Override
    public void getPizza(){
        System.out.print("Your Order is Chicken Pizza");
    }
}