package com.epam.AbstractFactoryMethod;

public class MessagesEsFactory implements MessagesAbstractFactory {

	@Override
	public Greetings getGreetings() {
		return new GreetingsEs();
	}

	@Override
	public Questions getQuestions() {
		return new QuestionsEs();
	}

}