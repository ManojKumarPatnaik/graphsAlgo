package com.epam.pmt.servicelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.persistencemanager.CrudOperations;
@Service
public class ModifyUrl implements ModifyUrlInterface {

	@Autowired
	CrudOperations crud;
	@Override
	public List<Account> modifyUrl(String url, String newUrl) {
		 List<Account>  result=new ArrayList<>();
		try {
		List<Account>accountDetailsList = crud.getAccountList().stream().filter(account -> account.getUrl().equals(url))
				.collect(Collectors.toList());
		
		if (!accountDetailsList.isEmpty()) {
			result=(crud.updateAccountUrl( url, newUrl));
			System.out.println(result);
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
















//		@SuppressWarnings({ "resource", "unused" })
//		Scanner scanner = new Scanner(System.in);
//		ArrayList<Account> accountList = data.getAccountList();
//		ModifyPasswordAccount modifyPasswordAccount = new ModifyPasswordAccount();
//		try {
//			System.out.println(modifyPasswordAccount.modifyUrl(accountList, url, newUrl));
//		} catch (InvalidUrlException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}