package com.gohooljava.com;

public class Animal {
    private String name;


    //Method overloading
    public void makeSound() {
        System.out.println("grrrr");
    }

    public void makeSound(String soundType) {
        System.out.println(soundType);

    }

    public void makeSound(String soundType, String loudness) {
        System.out.println(soundType + ", loudness " + loudness);

    }


}
