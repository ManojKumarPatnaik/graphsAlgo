package com.epam.HomeTask.lambda;

public class RunnableIntraface {

	public static void main(String[] args) {
		Runnable run = () -> {
			for (int i = 10; i <= 100; i++) {
				System.out.println(i);
			}
		};

		Thread thread = new Thread(run);
		thread.start();

	}

}
