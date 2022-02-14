package com.epam.pmt.servicelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.PasswordMismatchException;
import com.epam.pmt.persistencemanager.CrudOperations;
@Service
public class ModifyPassword implements ModifyPasswordInterface {

	@Autowired
	CrudOperations crud;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	
	@Override
	public List<Account> modifyPassword( String url, String newPassword) {
		 List<Account>  result=new ArrayList<>();
		try {
		List<Account>accountDetailsList = crud.getAccountList().stream().filter(account -> account.getUrl().equals(url))
				.collect(Collectors.toList());
		if (!accountDetailsList.isEmpty()) {
			String encrypted=encryptDecryptPassword.Encrypt(newPassword);
			result=(crud.updateAccountPassword( url, encrypted));
			System.out.println(result);
		}
		else {
			throw new InvalidUrlException("Oops! Entered URL is Invalid");
		}
		
		}catch(PasswordMismatchException|InvalidUrlException  message) {
			System.out.println("No records present with that data");
			
		}catch(Exception e) {
			System.out.println("Other exception"+e.getMessage());
			
		}
		return result;
		

	}

}





















//Scanner scanner = new Scanner(System.in);
//		ModifyPasswordAccount modifyPasswordAccount = new ModifyPasswordAccount();
//		System.out.println(modifyPasswordAccount.modifyPassword(accountList, url, newPassword));