package com.epam.Strategy_Design_Pattern;

public class Subtraction  implements Strategy{  
	  
    @Override  
    public float calculation(float a, float b) {  
        return a-b;  
    } 
}
