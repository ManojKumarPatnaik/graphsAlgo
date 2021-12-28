package com.epam.Builder_DesignPattern;

public class Person {
	private String name;
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public String getSchool() {
		return school;
	}

	public String getWorkplace() {
		return workplace;
	}

	private int age;
	private String birthplace;
	private String school;
	private String workplace;
	
	private Person() {}
	
	
	public static class Builder {
		private Person person;
		
		public Builder(String name) {
			person = new Person();
			person.name = name;
		}
		
		public Builder setBirthplace (String birthplace) {
			person.birthplace = birthplace;
			return this;
		}
		
		public AdultBuilder setAdult(int age) {
			if (age < 18) throw new IllegalArgumentException("is under age " + age);
			person.age = age;
			return new AdultBuilder(person);
		}
		
		public UnderAgeBuilder setUnderAge(int age) {
			if (age >= 18) throw new IllegalArgumentException("is adult " + age);
			person.age = age;
			return new UnderAgeBuilder(person);
		}
	
	}
	
	public static class AdultBuilder {
		private Person person;

		public AdultBuilder(Person person) {
			this.person = person;
		}

		public AdultBuilder setWorkplace(String workplace) {
			this.person.workplace = workplace;
			return this;
		}

		public Person build() {
			return person;
		}
	}
	
	public static class UnderAgeBuilder {
		
		private Person person;

		public UnderAgeBuilder(Person person) {
			this.person = person;
		}

		public UnderAgeBuilder setSchool(String school) {
			this.person.school = school;
			return this;
		}

		public Person build() {
			return person;
		}
	}
}
