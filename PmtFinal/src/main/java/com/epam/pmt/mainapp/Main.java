package com.epam.pmt.mainapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.epam.pmt.presentationlayer.DisplayMenuDetails;

@Configuration
@ComponentScan(basePackages = {"com.epam.pmt"} )
public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Main.class);
		DisplayMenuDetails displayMenuDetails=context.getBean(DisplayMenuDetails.class);
		
		String beams[]=context.getBeanDefinitionNames();
		for(String beam:beams) {
			System.out.println(beam);
		}
		
		logger.debug("Welcome To PasswordManagement Tool");
		displayMenuDetails.ui();
	}

}
 