package com.epam.pmt.persistencelayer;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.persistencemanager.CrudOperations;

public class DeleteAccountByUrl implements DeleteAccountByUrlInterface {

	@Override
	public boolean deleteAccountByUrl( String url) {
		
		CrudOperations crud=new CrudOperations();
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
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}