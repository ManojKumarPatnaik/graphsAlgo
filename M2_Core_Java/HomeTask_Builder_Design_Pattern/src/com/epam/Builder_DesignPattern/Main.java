package com.epam.Builder_DesignPattern;

public class Main {
	public static void main(String[] args) {

		// this code has to compile

		Person mother = new Person.Builder("Mary").setBirthplace("York").setAdult(37).setWorkplace("Google").build();
		System.out.println("Name : " + mother.getName() + " Birth place : " + mother.getBirthplace() + " Age : "
				+ mother.getAge() + " WorkPlace : " + mother.getWorkplace());
		Person son = new Person.Builder("Peter").setUnderAge(4).setSchool("York school").build();
		System.out.println("Name : " + son.getName() + " School name : " + son.getSchool() + " Age : " + son.getAge());

	}
}
