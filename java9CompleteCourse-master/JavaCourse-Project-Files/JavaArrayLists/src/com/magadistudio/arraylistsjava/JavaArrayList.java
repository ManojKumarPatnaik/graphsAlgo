package com.magadistudio.arraylistsjava;

import java.util.ArrayList;


public class JavaArrayList {
	

	public static void main(String[] args) {
		
		Cat cat = new Cat();
		cat.setAge(12);
		cat.setColor("Blue");
		cat.setName("Laura");
		
		Cat secondCat = new Cat();
		secondCat.setAge(11);
		secondCat.setColor("Orange");
		secondCat.setName("Joe");
		
		
		Cat thirdCat = new Cat();
		thirdCat.setAge(3);
		thirdCat.setColor("Red");
		thirdCat.setName("Betsie");
		
		
		
		
		//ArrayLists
		ArrayList<String> animals = new ArrayList<>();
		ArrayList<Cat> myCatsList = new ArrayList<>();
		
		myCatsList.add(thirdCat);
		myCatsList.add(secondCat);
		
		ArrayList<Cat> catList = new ArrayList<>();
		catList.add(cat);
		catList.add(secondCat);
		catList.add(thirdCat);
		
		// catList.get(1).showAll();
		
		
		for(Cat cats: catList){
			
			System.out.println(cats.getName() + ", " 
						+ cats.getAge() + ", " 
					+ cats.getColor());
			
			//cats.showAll();
		}
		
		
		
		
		
		
		
		
		
		
//		animals.add("Dog");
//		animals.add("Monkey");
//		animals.add("Cat");
//		animals.add("Donkey");
//		
//		
//		//animals.remove(0);
//		animals.remove("Cat");
//		
//		if(animals.contains("Dog")) {
//			animals.remove("Dog");
//		}else {
//			animals.add("Chicken");
//		}
//		
//		for(String animal : animals) {
//			
//			System.out.println("Animals are: " + animal);
//		}
		
		
//		if( animals.isEmpty()) {
//			System.out.println("Animal is empty");
//		}else {
//			
//			for(String animal : animals) {
//				
//				System.out.println("Animals are: " + animal);
//			}
			
		//}
		

		
		
		//System.out.println("Size: " + animals.size());
		

	}

}


class Cat {
	
	private String name;
	private String color;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void showAll() {
		System.out.println("Cat " + getName() +" , " 
	                        + getAge() + ", " + getColor());
	}
	
	
	
}







 
 
 
