package com.gohooljava.com;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        
	// write your code here
        // int, chars, long, float, doubles, booleans, byte ...
        //Integer, Characters, Long, Float, Double, Boolean, Byte...

        int b = 23;
        char myChar = 'D';

        Character myCharacter = new Character(myChar);

        int recoverChar = myCharacter.charValue();

        //physically wrapping my int primitive variable.
        Integer myObject = new Integer(b);

        //Unwrapping the Integer object
        int recoverInt = myObject.intValue();


        int i = 32;

        //Autoboxing happens automatically
        ArrayList<Integer> myArray = new ArrayList();
        myArray.add(i);

        int myItem =  myArray.get(0);


    }
}
