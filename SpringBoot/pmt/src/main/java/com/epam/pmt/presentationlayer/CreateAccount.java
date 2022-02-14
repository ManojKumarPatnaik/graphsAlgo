package com.epam.pmt.presentationlayer;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.database.CrudOperationsDbImpl;
import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;
import com.epam.pmt.validation.ValidationUrl;

@Component
public class CreateAccount   {
	@Autowired
	ValidationUrl validateUrl;
	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	CrudOperationsDbImpl crudOperations;

	@SuppressWarnings("resource")
	public void accountService(MasterUser currentUser) {
		Scanner scanner = new Scanner(System.in);
		String url,userName,password;
		do {
			System.out.println("Enter a valid urL");
			url = scanner.next();
		} while (!validateUrl.isValidURL(url));


		do {
			System.out.println("Enter User name");
			userName = scanner.next();
		} while (!validateUserName.isValidUserName(userName));
		do {
			System.out.println("Enter a valid password");
			password = scanner.next();
		} while (!validationPassword.validPassword(password));
		System.out.println("Enter group");
		String group = scanner.next();
		String encrypt = encryptDecryptPassword.Encrypt(password);

		Account account=new Account(url,userName,encrypt,group);
		
		account.setMasterUser(currentUser);
		crudOperations.add(account);
		System.out.println("Account added successfully");

	}


}
