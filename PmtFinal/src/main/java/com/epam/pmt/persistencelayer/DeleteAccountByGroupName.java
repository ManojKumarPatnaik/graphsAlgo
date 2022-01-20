package com.epam.pmt.persistencelayer;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;
import com.epam.pmt.persistencemanager.CrudOperations;

public class DeleteAccountByGroupName implements DeleteAccountByGroupNameInterface {

	
	CrudOperations crud=new CrudOperations();
	public boolean deleteAccountByGroup( String groupName) {
		boolean result=false;
		try {
		List<Account>accountDetailsList = crud.getAccountList().stream().filter(account -> account.getGroup().equals(groupName))
				.collect(Collectors.toList());
		
		if (!accountDetailsList.isEmpty()) {
			result=(crud.deleteAccountByGroupName(groupName));
			result=true;
		}
		else {
			throw new NoRecordFoundForGroup("Oops! No Record found for group");
		}
		
		}catch(NoRecordFoundForGroup message) {
			System.out.println(groupName+" group name doesn't exits in database.");
			
		}
		return result;
	}
}



//	 DeleteByGroupName deleteByGroupName=new DeleteByGroupName();
//		try {
//			accountDetailsList =CrudOperations.getAccountList();
////					data.getAccountList();
//			CrudOperations.deleteAccountByGroupName(accountDetailsList, groupName);
////			System.out.println(deleteByGroupName.deleteAccount(accountDetailsList, groupName));
//		} catch (NoRecordFoundForGroup e) {
//			e.printStackTrace();
//		}