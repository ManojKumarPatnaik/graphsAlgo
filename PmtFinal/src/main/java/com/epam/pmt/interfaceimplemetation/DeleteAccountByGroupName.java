package com.epam.pmt.interfaceimplemetation;

import java.util.List;

import com.epam.pmt.businesslogiclayer.DeleteByGroupName;
import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;
import com.epam.pmt.interfaces.DeleteAccountInterface;
import com.epam.pmt.persistencemanager.CrudOperations;

public class DeleteAccountByGroupName implements DeleteAccountInterface {
	 DeleteByGroupName deleteByGroupName=new DeleteByGroupName();


	public void deleteAccountByGroup(AccountDataBase data, String groupName) {
		List<Account> accountDetailsList = null;
		accountDetailsList =CrudOperations.getAccountList();
		CrudOperations.deleteAccountByGroupName(accountDetailsList, groupName);
//		try {
//			accountDetailsList =CrudOperations.getAccountList();
////					data.getAccountList();
//			CrudOperations.deleteAccountByGroupName(accountDetailsList, groupName);
////			System.out.println(deleteByGroupName.deleteAccount(accountDetailsList, groupName));
//		} catch (NoRecordFoundForGroup e) {
//			e.printStackTrace();
//		}
	}
}
