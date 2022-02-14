package com.epam.pmt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.epam.pmt.presentationlayer.DisplayMenuDetails;


@SpringBootApplication
public class PmtApplication {
	private static final Logger logger = LogManager.getLogger(PmtApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PmtApplication.class, args);
		logger.debug("Welcome To PasswordManagement Tool");
		context.getBean(DisplayMenuDetails.class).ui();

	}

}
