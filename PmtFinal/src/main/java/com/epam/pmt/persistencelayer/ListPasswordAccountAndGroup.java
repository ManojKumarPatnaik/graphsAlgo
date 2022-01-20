package com.epam.pmt.persistencelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;
import com.epam.pmt.persistencemanager.CrudOperations;

public class ListPasswordAccountAndGroup implements ListPasswordAccountInterface {
	CrudOperations crud=new CrudOperations();
	@Override
	public List<Account> getAccountByGroupName( String groupName) {
		List<Account> listOfGroupName=new ArrayList<>();
		
		try {
		List<Account>accountDetailsList = crud.getAccountList().stream().filter(account -> account.getGroup().equals(groupName))
				.collect(Collectors.toList());
		
		if (!accountDetailsList.isEmpty()) {
			listOfGroupName=(crud.listAccountByGroupName( groupName));
			System.out.println(listOfGroupName);
		}
		else
			throw new NoGroupFoundForAccount("No group present with that name");
		
		}catch(NoGroupFoundForAccount message) {
			System.out.println(groupName+" group name doesn't exits in database.");
			
		}
		return listOfGroupName;
	}

}











//Scanner scanner = new Scanner(System.in);
//				data.getAccountList();
//		DisplayAccountDetailsByGroup displayAccountDetailsByGroup = new DisplayAccountDetailsByGroup();
//		accountDetailsList = null;
//		try {
//			accountDetailsList = displayAccountDetailsByGroup.getListByGroup(accountDetailsList, groupName);
//		} catch (NoGroupFoundForAccount e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//			System.out.println(accountDetailsList);
//			for (Account account : accountDetailsList) {
//				System.out.println("Encrypted Password = " + account.getPassword() + ", URL = " + account.getUrl()
//						+ ", Group Name = " + account.getGroup() + ", Account Name = " + account.getUsername());
//			}