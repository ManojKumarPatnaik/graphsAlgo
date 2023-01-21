package com.magadistudio.animals;

 class Cat extends Animal {
	
	private String color;
	
	
	
	
	public String getColor() {
		return color;
	}




	public void setColor(String color) {
		this.color = color;
	}


	public void showCat() {
		System.out.println("Cat profile: " 
						+ getColor() + ", " + getFood() + ", " 
						+ getName() + ", " + getNumLegs() );
		
	}




	@Override
	public void makeNoise() {
		System.out.println("Cat purring...");
		
	}
	


	

}
