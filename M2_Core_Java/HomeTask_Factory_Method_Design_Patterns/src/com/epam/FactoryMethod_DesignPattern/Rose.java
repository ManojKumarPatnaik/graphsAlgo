package com.epam.FactoryMethod_DesignPattern;

public class Rose implements Flowers{
	private static final double rosePrice=1.0;
	private static double price;
	private int quantity;

	
    @Override
    public double getPrice(int quantity) {
    	this.quantity=quantity;
		if (this.quantity < 0) {
		     
		     throw new IllegalArgumentException("Only positive numbers"); 
		} 
		price=this.quantity*rosePrice;
		
    	return price;
    	}
}
