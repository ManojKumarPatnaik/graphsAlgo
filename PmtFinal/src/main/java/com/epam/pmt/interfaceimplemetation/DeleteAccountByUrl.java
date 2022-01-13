package com.epam.pmt.interfaceimplemetation;

import java.util.List;

import com.epam.pmt.businesslogiclayer.DeletePasswordAccount;
import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.interfaces.DeleteAccountByUrlInterface;
import com.epam.pmt.persistencemanager.CrudOperations;

public class DeleteAccountByUrl implements DeleteAccountByUrlInterface {

	@Override
	public void deleteAccountByUrl(AccountDataBase data, String url) {
//		DeletePasswordAccount deletePasswordAccount = new DeletePasswordAccount();
		List<Account> accountDetailsList = null;
		accountDetailsList =CrudOperations.getAccountList();
		CrudOperations.deleteAccountByUrl(accountDetailsList, url);

//		try {
//			accountDetailsList = data.getAccountList();
//			System.out.println(deletePasswordAccount.deleteAccountPassword(accountDetailsList, url));
//
//		} catch (InvalidUrlException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
