package com.epam.AbstractFactoryMethod;

public class QuestionsEs implements Questions {

	@Override
	public String askTime() {
		return "¿qué hora es?";
	}

	@Override
	public String askWeather() {
		return "¿qué tiempo hace?";
	}

}