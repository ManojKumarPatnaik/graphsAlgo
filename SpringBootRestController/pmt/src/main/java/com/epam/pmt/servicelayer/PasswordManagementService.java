package com.epam.pmt.servicelayer;

import java.util.List;

import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;

public interface PasswordManagementService {
	boolean addAccount(Account account, MasterUser current);

	List<Account> getAccountByGroupName(String groupName, MasterUser current);

	boolean deleteAccountByGroup(String groupName, MasterUser current);

	boolean deleteAccountByUrl(String url, MasterUser current);

	String getPassword(String accountUsername, MasterUser current);

	List<Account> viewAllAccounts(MasterUser current);

	Account getAccountById(int id);

	Account updateAccount(Account account, MasterUser current);

}
