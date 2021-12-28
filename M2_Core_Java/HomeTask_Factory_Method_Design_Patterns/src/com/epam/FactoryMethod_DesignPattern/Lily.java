package com.epam.FactoryMethod_DesignPattern;

public class Lily implements Flowers{
	private static final double lilyPrice=3.0;
	private static double price;
	int quantity;
    @Override
    public double getPrice(int quantity) {
    	this.quantity=quantity;
		if (this.quantity < 0) {
		     
		     throw new IllegalArgumentException("Only positive numbers"); 
		} 
		price=this.quantity*lilyPrice;
		
    	return price;
    	}

}