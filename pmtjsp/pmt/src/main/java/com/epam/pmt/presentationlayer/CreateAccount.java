package com.epam.pmt.presentationlayer;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.servicelayer.CrudOperationsServiceImpl;
import com.epam.pmt.validation.AccountValidation;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;

@Component
public class CreateAccount   {
	@Autowired
	AccountValidation validateUrl;
	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	CrudOperationsServiceImpl crudService;
	private static final Logger logger = LogManager.getLogger(CreateAccount.class);
	@SuppressWarnings("resource")
	public void accountService(MasterUser currentUser) {
		Scanner scanner = new Scanner(System.in);
		String url;
		String userName;
		String password;
		do {
			logger.info("Enter a valid urL");
			url = scanner.next();
		} while (!validateUrl.isValidURL(url));


		do {
			logger.info("Enter User name");
			userName = scanner.next();
		} while (!validateUserName.isValidUserName(userName));
		do {
			logger.info("Enter a valid password");
			password = scanner.next();
		} while (!validationPassword.validPassword(password));
		logger.info("Enter group");
		String group = scanner.next();
		String encrypt = encryptDecryptPassword.encrypt(password);

		Account account=new Account(url,userName,encrypt,group);
		
		account.setMasterUser(currentUser);
		crudService.addAccount(account);
		logger.info("Account added successfully");

	}


}
