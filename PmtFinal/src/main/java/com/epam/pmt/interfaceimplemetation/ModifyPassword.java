package com.epam.pmt.interfaceimplemetation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.pmt.businesslogiclayer.ModifyPasswordAccount;
import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;
import com.epam.pmt.interfaces.ModifyPasswordInterface;
import com.epam.pmt.persistencemanager.CrudOperations;

public class ModifyPassword implements ModifyPasswordInterface {

	@Override
	public List<Account> modifyPassword(AccountDataBase data, String url, String newPassword) {
		List<Account> accountDetailsList = null;
		@SuppressWarnings({ "resource", "unused" })
		Scanner scanner = new Scanner(System.in);
		accountDetailsList = CrudOperations.getAccountList();
		CrudOperations.updateAccountPassword(accountDetailsList, url, newPassword);
//		ModifyPasswordAccount modifyPasswordAccount = new ModifyPasswordAccount();
//		System.out.println(modifyPasswordAccount.modifyPassword(accountList, url, newPassword));

		return accountDetailsList;
	}

}
