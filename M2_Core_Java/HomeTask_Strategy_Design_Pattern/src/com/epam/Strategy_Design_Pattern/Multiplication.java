package com.epam.Strategy_Design_Pattern;

public class Multiplication implements Strategy{  
	  
    @Override  
    public float calculation(float a, float b){  
        return a*b;  
    } 
}
