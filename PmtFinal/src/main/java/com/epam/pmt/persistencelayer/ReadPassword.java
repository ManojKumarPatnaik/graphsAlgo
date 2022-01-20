package com.epam.pmt.persistencelayer;

import java.util.List;
import java.util.Scanner;

import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.persistencemanager.CrudOperations;

public class ReadPassword implements ReadPasswordInterface {
	CrudOperations crud=new CrudOperations();
	EncryptionAndDecryption encrypt=new EncryptionAndDecryption();


	@SuppressWarnings("resource")
	@Override
	public boolean getPassword( String url, String accountUsername) {
		boolean result=false;
		Scanner scanner = new Scanner(System.in);
		List<Account>  accountList=  crud.getDecryptedPassword( url, accountUsername);
		String temporary = null;
		try {
			
			temporary=encrypt.getEncryptedPassword(accountList,url, accountUsername);
					
		} catch (AccountDoesNotExistException | InvalidUrlException e1) {
			e1.printStackTrace();
		}
		if (!temporary.equals("")) {
			result =true;
			System.out.println("The password is : " + temporary);
		System.out.println("Enter option");
		System.out.println("1 View decryptrd password");
		System.out.println("Press 2 if no Need");
		int number = scanner.nextInt();

		if (number == 1) {
			String temporary2 = null;
			try {
				temporary2 = encrypt.getDecryptedPassword(accountList, url, accountUsername);
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				e.printStackTrace();
			}
			System.out.println("Decrypted Password : " + temporary2.toString());
		}

		else {
			System.err.println("no account is present");
		}
		}
		return result;
	}

}

//				data.getAccountList();