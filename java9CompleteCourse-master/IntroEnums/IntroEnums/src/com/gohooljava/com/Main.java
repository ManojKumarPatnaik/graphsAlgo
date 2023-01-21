package com.gohooljava.com;

import java.util.ArrayList;

public class Main {

    //Enums = Enumerations
    public  enum Members {JERRY, BOBBY, LARRY}
    public static Members selectedPerson;

    public static final int JERRY = 1;
    public static final int BOBBY = 2;
    public static final int LARRY = 3;

    public static void main(String[] args) {



        selectedPerson = Members.BOBBY;

       if (selectedPerson.equals(Members.BOBBY)) {
           System.out.println("Bobby");
       }
       if (selectedPerson.equals(Members.JERRY)) {
           System.out.println("Jerry");
       }





//        int selectedPerson = 111;
//
//        if (selectedPerson == JERRY) {
//            System.out.println("Jerry!");
//        }

    }
}
