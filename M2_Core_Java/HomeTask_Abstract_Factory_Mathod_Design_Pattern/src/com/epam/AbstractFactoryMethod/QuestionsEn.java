package com.epam.AbstractFactoryMethod;

public class QuestionsEn implements Questions {

	@Override
	public String askTime() {
		return "what time is it?";
	}

	@Override
	public String askWeather() {
		return "how is the weather?";
	}

	
}