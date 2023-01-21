package com.gohooljava.com;

public class Dog extends Animal{

    private String name;

    public void move() {
        System.out.println("Move!");
    }

    //Override makesound function from our parent class - Animal
    public void makeSound() {
        System.out.println("Woof!");
    }
    public void makeSound(String soundType) {
        System.out.println(soundType);

    }
}
