package com.epam.Decorator_DesignPattern;

public class PizzaWithToppings extends PizzaDecorator{
    public PizzaWithToppings(Pizza pizza){
        super(pizza);
    }
    private  void  addToppings(){
        System.out.print(" with toppings");
    }
    @Override
   public void getPizza(){
        pizza.getPizza();
        addToppings();
    }
}
