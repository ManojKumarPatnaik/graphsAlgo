package com.epam.pmt.servicelayer;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.persistencemanager.CrudOperations;

@Service
public class ReadPassword implements ReadPasswordInterface {
	@Autowired
	CrudOperations crud;
	@Autowired
	EncryptionAndDecryption encrypt;

	@SuppressWarnings("resource")
	@Override
	public boolean getPassword(String url, String accountUsername) {
		boolean result = false;
		Scanner scanner = new Scanner(System.in);
		List<Account> accountList = crud.getDecryptedPassword(url, accountUsername);
		String temporary = null;
		try {

			temporary = encrypt.getEncryptedPassword(accountList, url, accountUsername);

		} catch (AccountDoesNotExistException | InvalidUrlException message) {
			System.out.println("No account is present");
		}
		if (!temporary.equals("")) {
			result = true;
			System.out.println("The password is : " + temporary);
			System.out.println("Enter option");
			System.out.println("1 View decryptrd password");
			System.out.println("Press 2 if no Need");
			int number = scanner.nextInt();

			if (number == 1) {
				String temporary2 = null;
				try {
					temporary2 = encrypt.getDecryptedPassword(accountList, url, accountUsername);
				} catch (AccountDoesNotExistException | InvalidUrlException message) {
					System.out.println("No account is present");
				}
				System.out.println("Decrypted Password : " + temporary2.toString());
			}

			else {
				System.out.println("No account is present");
			}
		}
		return result;
	}

}
