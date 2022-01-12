package com.epam.pmt.presentationlayer;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;
import com.epam.pmt.interfaceimplemetation.CreateAccountDetails;
import com.epam.pmt.interfaces.CreateAccountInterface;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;
import com.epam.pmt.validation.ValidationUrl;

public class CreateAccount implements CreateAccountInterface {
//	public static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
//	private static EntityManager emanager=emFactory.createEntityManager();

	public void accountService(AccountDataBase data) {
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
//		emanager.getTransaction().begin();
//		emanager.persist(account);
//		emanager.getTransaction().commit();
		System.out.println("Account added successfully");

	}

}
