package com.gohooljava.com;

public class Main {

    public static void main(String[] args) {

        Vet myVet = new Vet();

        Cat myCat = new Cat();
        Dog myDog = new Dog();

        myVet.giveShot(myCat);
        myVet.giveShot(myDog);













//        myDog.makeSound();
//        myDog.makeSound("Wooff!");
//        myDog.makeSound("Woof", "very loud!");

       // myDog.makeSound("another Woof!");
    }
}
