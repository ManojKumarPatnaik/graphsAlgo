package com.epam.AbstractFactoryMethod;

public class MessagesEnFactory implements MessagesAbstractFactory {

	@Override
	public Greetings getGreetings() {
		return new GreetingsEn();
	}

	@Override
	public Questions getQuestions() {
		return new QuestionsEn();
	}

}