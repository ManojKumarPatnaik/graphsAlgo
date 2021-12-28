package com.epam.FactoryMethod_DesignPattern;

public class BuoquetFactory {
	public Flowers getFlowers(String FlowerType) {
		 if(FlowerType.equalsIgnoreCase("Rose")){
	         return new Rose();
		 } else if(FlowerType.equalsIgnoreCase("Jasmine")){
	         return new Jasmine();
	         
	      } else if(FlowerType.equalsIgnoreCase("Lily")){
	         return new Lily();
	      }
	      else return null;
}
}
