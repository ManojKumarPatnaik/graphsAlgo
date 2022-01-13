package com.epam.pmt.interfaceimplemetation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.pmt.businesslogiclayer.ModifyPasswordAccount;
import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.interfaces.ModifyUrlInterface;
import com.epam.pmt.persistencemanager.CrudOperations;

public class ModifyUrl implements ModifyUrlInterface {

	@Override
	public List<Account> modifyUrl(AccountDataBase data, String url, String newUrl) {
		List<Account> accountDetailsList = null;
//		@SuppressWarnings({ "resource", "unused" })
		accountDetailsList= CrudOperations.getAccountList();
		CrudOperations.updateAccountUrl(accountDetailsList, url, newUrl);
//		Scanner scanner = new Scanner(System.in);
//		ArrayList<Account> accountList = data.getAccountList();
//		ModifyPasswordAccount modifyPasswordAccount = new ModifyPasswordAccount();
//		try {
//			System.out.println(modifyPasswordAccount.modifyUrl(accountList, url, newUrl));
//		} catch (InvalidUrlException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return accountDetailsList;
	}

}
