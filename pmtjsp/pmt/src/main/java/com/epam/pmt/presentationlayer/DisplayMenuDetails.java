package com.epam.pmt.presentationlayer;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.exceptions.PasswordMismatchException;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;

@Component
public class DisplayMenuDetails {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(DisplayMenuDetails.class);
	private static final Scanner scanner = new Scanner(System.in);

	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;
	@Autowired
	MasterAccount masterAccount;
	@Autowired
	Login login;

	public void ui() throws NullPointerException, PasswordMismatchException {

		int option = 0;
		while (true) {
			logger.info("Enter number for Respective Operation");
			logger.info("1.Register as master User");
			logger.info("2.Login as Master User into Password Management system");
			logger.info("3.To exit Application");
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				scanner.next();
				ui();

			}

			switch (option) {
			case 1:
				String username1;

				do {
					logger.info("Enter Master User Name ");
					username1 = scanner.next();
				} while (!validateUserName.isValidUserName(username1));

				logger.info("Enter MasterPassword ");
				logger.info("note  : password must be encountered with 1 upper case ");
				logger.info("note  : password must be encountered with 1 lower case ");
				logger.info("note  : password must be encountered with 1 numeric ");

				String password = scanner.next();

				if (validationPassword.validPassword(password)) {
					logger.debug("Validating Password Criteria : Access Granted.");
					logger.debug("Registered successfully");
				}
				masterAccount.addMasterUser(username1, password);
				break;

			case 2:
				login.login();
				break;
			default:
				break;

			}

			if (option == 3) {
				logger.warn("Thank you for using Password Management Tool. Have a Great day!!!\n ");

				logger.info("Exited Successfully from application");
				break;
			}

		}
	}

}
