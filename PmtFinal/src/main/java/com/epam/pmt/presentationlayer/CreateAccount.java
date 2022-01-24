package com.epam.pmt.presentationlayer;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.entity.Account;
import com.epam.pmt.mainapp.Main;
import com.epam.pmt.servicelayer.CreateAccountDetails;
import com.epam.pmt.servicelayer.CreateAccountInterface;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;
import com.epam.pmt.validation.ValidationUrl;

@Component
public class CreateAccount implements CreateAccountInterface {
	@Autowired
	ValidationUrl validateUrl;
	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;
	@Autowired
	CreateAccountDetails createAccountDetails;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	Account account;

	@SuppressWarnings("resource")
	public void accountService() {
		Scanner scanner = new Scanner(System.in);
		ApplicationContext context=new AnnotationConfigApplicationContext(Main.class);
		String url;
		do {
			System.out.println("Enter a valid urL");
			url = scanner.next();
		} while (!validateUrl.isValidURL(url));

		String userName;

		do {
			System.out.println("Enter User name");
			userName = scanner.next();
		} while (!validateUserName.isValidUserName(userName));
		String password;
		do {
			System.out.println("Enter a valid password");
			password = scanner.next();
		} while (!validationPassword.validPassword(password));
		System.out.println("Enter group");
		String group = scanner.next();
		String encrypt = encryptDecryptPassword.Encrypt(password);
		account=context.getBean(Account.class);
		account.setGroup(group);
		account.setPassword(encrypt);
		account.setUrl(url);
		account.setUsername(userName);
		
		createAccountDetails.add(account);
		System.out.println("Account added successfully");

	}

}
