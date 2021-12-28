package com.epam.AbstractFactoryMethod;

public class Main {

	public static void main(String[] args) {
		Questions questions = new QuestionsEn();

		System.out.println("Ask Time in English : " + questions.askTime());
		System.out.println("Ask Weather in English : " + questions.askWeather());

		Greetings greetings = new GreetingsEn();

		System.out.println("Morning greetings in English : " + greetings.goodMorning());
		System.out.println("Afternoon greetings in English : " + greetings.goodAfternoon());

		Questions questionsEs = new QuestionsEs();

		System.out.println("Ask Time in Spanish : " + questionsEs.askTime());
		System.out.println("Ask Weather in Spanish : " + questionsEs.askWeather());

		Greetings greetingsEs = new GreetingsEs();

		System.out.println("Morning greetings in Spanish : " + greetingsEs.goodMorning());
		System.out.println("Afternoon greetings in Spanish : " + greetingsEs.goodAfternoon());

	}

}
