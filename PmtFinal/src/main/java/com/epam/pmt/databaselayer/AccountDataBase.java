package com.epam.pmt.databaselayer;

import java.util.ArrayList;

import com.epam.pmt.entity.Account;

public class AccountDataBase {

	private ArrayList<Account> accountDetailsList = new ArrayList<Account>();

	public ArrayList<Account> getAccountList() {
		return accountDetailsList;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		accountDetailsList = accountList;
	}

	public void add(Account accountData) {
		this.accountDetailsList.add(accountData);
	}
}
