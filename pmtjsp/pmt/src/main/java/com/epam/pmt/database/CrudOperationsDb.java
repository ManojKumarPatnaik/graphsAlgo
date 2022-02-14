package com.epam.pmt.database;

import java.util.List;

import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;

public interface CrudOperationsDb {
	public boolean add(Account account);

	public List<Account> getAccountList();

	public List<MasterUser> getAllUsers();

	public List<Account> listAccountByGroupName( String group);

	public List<Account> updateAccountByGroupName( String group, String newgroup);

	public boolean deleteAccountByGroupName( String group);

	public List<Account> updateAccountPassword( String url, String newpassword);

	public List<Account> updateAccountUrl( String url, String newUrl);

	public boolean deleteAccountByUrl( String url);

	public List<Account> getDecryptedPasswordList(  String username);

}
