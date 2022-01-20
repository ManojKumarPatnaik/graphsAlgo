package com.epam.pmt.mainapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.presentationlayer.DisplayMenuDetails;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		logger.debug("Welcome To PasswordManagement Tool");
		DisplayMenuDetails.ui();
	}

}
 