package com.epam.pmt.servicelayer;

import java.util.List;

import com.epam.pmt.entity.Account;

public interface CrudService {
	List<Account> getAccountByGroupName(String  groupName);

	List<Account> modifyGroupDetails(String groupName, String newGroup);

	List<Account> modifyPassword(String url, String newPassword);

	boolean deleteAccountByGroup(String groupName);

	List<Account> modifyUrl(String url, String newUrl);

	boolean deleteAccountByUrl(String url);

	boolean getPassword( String url, String accountUsername);

}
