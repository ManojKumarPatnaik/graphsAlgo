package com.epam.pmt.servicelayer;

import java.util.List;

import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;

public interface PasswordManagementService {
	boolean addAccount(Account account);
	
	List<Account> getAccountByGroupName(String  groupName);

	void deleteAccountByGroup(String groupName);

	void deleteAccountByUrl(String url);

	String getPassword(  String accountUsername);
	
	List<Account> viewAllAccounts();
	
	List<MasterUser> viewAllUsers();
	
	Account getAccountById(int id);
	
	void updateAccount(Account account);

}
