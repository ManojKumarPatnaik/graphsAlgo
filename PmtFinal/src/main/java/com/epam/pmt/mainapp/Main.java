package com.epam.pmt.mainapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.presentationlayer.DisplayMenuDetails;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
//	public static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
//	public static EntityManager emanager=emFactory.createEntityManager();

	public static void main(String[] args) {
		logger.debug("Welcome To PasswordManagement Tool");
		DisplayMenuDetails.ui();
	}

}
