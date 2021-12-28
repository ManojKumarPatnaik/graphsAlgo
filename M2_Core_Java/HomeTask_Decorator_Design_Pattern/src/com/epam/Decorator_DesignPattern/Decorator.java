package com.epam.Decorator_DesignPattern;

public class Decorator {
    public static void main(String[] args) {

       
        System.out.println("\nCustomer one ");
        Pizza chickenPizza= new ChickenPizza(new ChickenPizza());
        chickenPizza.getPizza();
        System.out.println();


        System.out.println("\nCustomer two ");
        Pizza mushroomPizza= new MushroomPizza();
        mushroomPizza.getPizza();
        System.out.println();


        System.out.println("\nCustomer three ");
        Pizza mushroomPizzaWithToppings= new PizzaWithToppings(new MushroomPizza());
        mushroomPizzaWithToppings.getPizza();
        System.out.println();


        System.out.println("\nCustomer four ");
        Pizza chickenPizzaWithToppings= new PizzaWithToppings(new ChickenPizza());
        chickenPizzaWithToppings.getPizza();
        System.out.println();
    }
}