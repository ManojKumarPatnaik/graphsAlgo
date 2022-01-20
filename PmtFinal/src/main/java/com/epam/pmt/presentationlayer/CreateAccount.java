package com.epam.pmt.presentationlayer;

import java.util.Scanner;

import com.epam.pmt.entity.Account;
import com.epam.pmt.persistencelayer.CreateAccountDetails;
import com.epam.pmt.persistencelayer.CreateAccountInterface;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;
import com.epam.pmt.validation.ValidationUrl;

public class CreateAccount implements CreateAccountInterface {

	public void accountService() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		ValidationUrl validateUrl = new ValidationUrl();
		
		String url;
		do {
			System.out.println("Enter a valid urL");
			url = scanner.next();
		} while (!validateUrl.isValidURL(url));

		String userName;
		ValidateUserName validateUserName = new ValidateUserName();

		do {
			System.out.println("Enter User name");
			userName = scanner.next();
		} while (!validateUserName.isValidUserName(userName));
		ValidationPassword validationPassword = new ValidationPassword();
		String password;
		do {
			System.out.println("Enter a valid password");
			password = scanner.next();
		} while (!validationPassword.validPassword(password));
		System.out.println("Enter group");
		String group = scanner.next();
		Account account = new Account(url, userName, password, group);
		CreateAccountDetails createAccountService=new CreateAccountDetails();
		createAccountService.add(account);
		System.out.println("Account added successfully");

	}

}
