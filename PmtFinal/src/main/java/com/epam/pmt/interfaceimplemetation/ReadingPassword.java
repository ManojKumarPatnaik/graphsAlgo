package com.epam.pmt.interfaceimplemetation;

import java.util.List;
import java.util.Scanner;

import com.epam.pmt.businesslogiclayer.PasswordReader;
import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.interfaces.ReadPasswordInterface;
import com.epam.pmt.persistencemanager.CrudOperations;

public class ReadingPassword implements ReadPasswordInterface {

	@Override
	public void getPassword(AccountDataBase data, String url, String accountUsername) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		PasswordReader readPassword = new PasswordReader();
		List<Account> accountList = CrudOperations.getAccountList();
		CrudOperations.getDecryptedPassword(accountList, url, accountUsername);
//				data.getAccountList();
		String temporary = null;
		try {
			temporary = readPassword.getPassword(accountList, url, accountUsername);
		} catch (AccountDoesNotExistException | InvalidUrlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (!temporary.equals(""))
			System.out.println("The password is : " + temporary);
		System.out.println("Enter option");
		System.out.println("1 View decryptrd password");
		System.out.println("Press 2 if no Need");
		int number = scanner.nextInt();

		if (number == 1) {
			String temporary2 = null;
			try {
				temporary2 = readPassword.getDecryptedPassword(accountList, url, accountUsername);
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Decrypted Password : " + temporary2.toString());
		}

		else
			System.err.println("no account is present");
	}

}
