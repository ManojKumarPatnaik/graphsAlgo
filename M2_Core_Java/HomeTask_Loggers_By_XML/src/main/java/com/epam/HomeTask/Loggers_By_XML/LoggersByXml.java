package com.epam.HomeTask.Loggers_By_XML;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggersByXml {
	private static final Logger log = LogManager.getLogger(LoggersByXml.class);

	public static void main(String[] args) {

		System.out.println("Logger by xml ");
		log.trace("This is Trace Method");
		log.debug("This is debug Method");
		log.info("This is info Method");
		log.warn("This is warn Method");
		System.out.println("Levels of Errors");
		log.fatal("This is fatal Method");
		log.error("This is error Method");
		System.out.println("Completed");
	}
}