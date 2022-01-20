package com.epam.pmt.persistencelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.PasswordMismatchException;
import com.epam.pmt.persistencemanager.CrudOperations;

public class ModifyPassword implements ModifyPasswordInterface {

	CrudOperations crud=new CrudOperations();
	@Override
	public List<Account> modifyPassword( String url, String newPassword) {
		 List<Account>  result=new ArrayList<>();
		try {
		List<Account>accountDetailsList = crud.getAccountList().stream().filter(account -> account.getUrl().equals(url))
				.collect(Collectors.toList());
		
		if (!accountDetailsList.isEmpty()) {
			EncryptDecryptPassword obj = new EncryptDecryptPassword();
			String encrypted=obj.Encrypt(newPassword);
			result=(crud.updateAccountPassword( url, encrypted));
			System.out.println(result);
		}
		else {
			throw new InvalidUrlException("Oops! Entered URL is Invalid");
		}
		
		}catch(PasswordMismatchException|InvalidUrlException  message) {
			System.out.println("No records present with that data");
			
		}
		return result;
		

	}

}





















//Scanner scanner = new Scanner(System.in);
//		ModifyPasswordAccount modifyPasswordAccount = new ModifyPasswordAccount();
//		System.out.println(modifyPasswordAccount.modifyPassword(accountList, url, newPassword));