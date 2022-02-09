package com.epam.pmt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PmtApplication {
	private static final Logger logger = LogManager.getLogger(PmtApplication.class);

	public static void main(String[] args) {
				SpringApplication.run(PmtApplication.class, args);
		logger.debug("Welcome To PasswordManagement Tool");

	}

}
