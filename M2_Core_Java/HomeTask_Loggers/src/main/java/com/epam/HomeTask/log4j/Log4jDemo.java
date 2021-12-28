package com.epam.HomeTask.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	private static final Logger logger =LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
	
		System.out.println("Hello World !");
		logger.trace("This is Trace Method");
		logger.debug("This is debug Method");
		logger.info("This is info Method");
		logger.warn("This is warn Method");
		System.out.println("Levels of Errors");
		logger.fatal("This is fatal Method");
		logger.error("This is error Method");
		System.out.println("Completed");
	}

}
