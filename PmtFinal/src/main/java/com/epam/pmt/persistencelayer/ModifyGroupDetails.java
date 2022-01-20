package com.epam.pmt.persistencelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;
import com.epam.pmt.persistencemanager.CrudOperations;

public class ModifyGroupDetails implements ModifyGroupDetailsInterface {
	CrudOperations crud=new CrudOperations();
	@Override
	public List<Account> modifyGroupDetails( String groupName, String newGroup) {
		 List<Account>  result=new ArrayList<>();
		try {
		List<Account>accountDetailsList = crud.getAccountList().stream().filter(account -> account.getGroup().equals(groupName))
				.collect(Collectors.toList());
		
		if (!accountDetailsList.isEmpty()) {
			result=(crud.updateAccountByGroupName(groupName,newGroup));
			System.out.println(result);
		}
		else {
			throw new NoGroupFoundForAccount("No group present with that name");
		}
		
		}catch(NoGroupFoundForAccount message) {
			System.out.println(groupName+" group name doesn't exits in database.");
			
		}
		return result;
	}
}






















//Scanner scanner = new Scanner(System.in);
//				data.getAccountList();
//		GroupModification modifyGroup = new GroupModification();
//		try {
//			System.out.println(modifyGroup.modifyGroupName(accountDetailsList, groupName, newGroup));
//		} catch (NoGroupFoundForAccount e) {
//			e.printStackTrace();
//		}