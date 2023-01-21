package com.magadistudio.animals;

public class AnimalTest {

	public static void main(String[] args) {
		
		
		
		Cat cat = new Cat();
		
		Lion lion = new Lion();
		lion.setName("Simba");
		lion.setFood("Meat");
		lion.setNumLegs(4);
		
		cat.setName("Moz");
		cat.setFood("Cat Food");
		cat.setColor("Purple");
		cat.setNumLegs(4);
		
		cat.showCat();
//		System.out.println("My lion is " + lion.getName() + " , " + lion.getFood() 
//		               + ", " + lion.getNumLegs());
		
		
		
		
		cat.makeNoise();
		

	}

}
