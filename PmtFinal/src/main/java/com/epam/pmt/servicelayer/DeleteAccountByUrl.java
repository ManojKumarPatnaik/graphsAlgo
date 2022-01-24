package com.epam.pmt.servicelayer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.persistencemanager.CrudOperations;
@Service
public class DeleteAccountByUrl implements DeleteAccountByUrlInterface {
	@Autowired
	CrudOperations crud;
	@Override
	public boolean deleteAccountByUrl( String url) {
		
		boolean result=false;
		try {
		List<Account>accountDetailsList = crud.getAccountList().stream().filter(account -> account.getUrl().equals(url))
				.collect(Collectors.toList());
		
		if (!accountDetailsList.isEmpty()) {
			result=(crud.deleteAccountByUrl( url));
		}
		else {
			throw new InvalidUrlException("Oops! Entered URL is Invalid");
		}
		
		}catch(InvalidUrlException message) {
			System.out.println(url+" Entered URL doesn't exits in database.");
			
		}
		return result;
		
		
	}
}













//public void deleteAccountByUrl(AccountDataBase data, String url) {
//		DeletePasswordAccount deletePasswordAccount = new DeletePasswordAccount();
//		try {
//			accountDetailsList = data.getAccountList();
//			System.out.println(deletePasswordAccount.deleteAccountPassword(accountDetailsList, url));
//
//		} catch (InvalidUrlException e) {
//			e.printStackTrace();
//		}