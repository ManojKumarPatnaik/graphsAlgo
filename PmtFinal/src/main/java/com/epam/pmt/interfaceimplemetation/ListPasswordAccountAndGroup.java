package com.epam.pmt.interfaceimplemetation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.pmt.businesslogiclayer.DisplayAccountDetailsByGroup;
import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;
import com.epam.pmt.interfaces.ListPasswordAccountInterface;
import com.epam.pmt.persistencemanager.CrudOperations;

public class ListPasswordAccountAndGroup implements ListPasswordAccountInterface {

	@Override
	public void getAccountByGroupName(AccountDataBase data, String groupName) {
		List<Account> accountDetailsList = null;
		@SuppressWarnings({ "resource", "unused" })
		Scanner scanner = new Scanner(System.in);
		accountDetailsList = CrudOperations.getAccountList();
//				data.getAccountList();
//		DisplayAccountDetailsByGroup displayAccountDetailsByGroup = new DisplayAccountDetailsByGroup();
		CrudOperations.ListAccountByGroupName(accountDetailsList, groupName);
//		accountDetailsList = null;
//		try {
//			accountDetailsList = displayAccountDetailsByGroup.getListByGroup(accountDetailsList, groupName);
//		} catch (NoGroupFoundForAccount e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if (accountDetailsList.size() > 0) {
//			System.out.println(accountDetailsList);
//			for (Account account : accountDetailsList) {
//				System.out.println("Encrypted Password = " + account.getPassword() + ", URL = " + account.getUrl()
//						+ ", Group Name = " + account.getGroup() + ", Account Name = " + account.getUsername());
//			}
		}
		else
			System.out.println("No group present with that name");
	}

}
