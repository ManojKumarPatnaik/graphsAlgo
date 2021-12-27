package com.epam.HomeTask.Streams;

public class Product {

	protected String name;
	protected int price;
	protected String grade;
	protected String category;

	public Product() {

	}

	public Product(String name, int price, String grade, String category) {

		this.name = name;
		this.price = price;
		this.grade = grade;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		String result = "Name is " + this.name + "Price " + this.price + "Category " + this.category + "Grade "
				+ this.grade;

		return result;
	}

}
