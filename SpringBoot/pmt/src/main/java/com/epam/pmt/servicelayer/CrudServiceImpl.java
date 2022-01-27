package com.epam.pmt.servicelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pmt.database.CrudOperationsDbImpl;
import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;
import com.epam.pmt.exceptions.PasswordMismatchException;

@Service
public class CrudServiceImpl implements CrudService {
	@Autowired
	CrudOperationsDbImpl crud;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	EncryptionAndDecryption encrypt;

	@Override
	public List<Account> getAccountByGroupName(String groupName) {
		List<Account> listOfGroupName = new ArrayList<>();

		try {
			List<Account> accountDetailsList = crud.getAccountList().stream()
					.filter(account -> account.getGroup().equals(groupName)).collect(Collectors.toList());

			if (!accountDetailsList.isEmpty()) {
				listOfGroupName = (crud.listAccountByGroupName(groupName));
				System.out.println(listOfGroupName);
			} else
				throw new NoGroupFoundForAccount("No group present with that name");

		} catch (NoGroupFoundForAccount message) {
			System.out.println(groupName + " group name doesn't exits in database.");

		}
		return listOfGroupName;
	}

	@Override
	public List<Account> modifyGroupDetails(String groupName, String newGroup) {
		List<Account> result = new ArrayList<>();
		try {
			List<Account> accountDetailsList = crud.getAccountList().stream()
					.filter(account -> account.getGroup().equals(groupName)).collect(Collectors.toList());

			if (!accountDetailsList.isEmpty()) {
				result = (crud.updateAccountByGroupName(groupName, newGroup));
				System.out.println(result);
			} else {
				throw new NoGroupFoundForAccount("No group present with that name");
			}

		} catch (NoGroupFoundForAccount message) {
			System.out.println(groupName + " group name doesn't exits in database.");

		}
		return result;
	}

	@Override
	public List<Account> modifyPassword(String url, String newPassword) {
		List<Account> result = new ArrayList<>();
		try {
			List<Account> accountDetailsList = crud.getAccountList().stream()
					.filter(account -> account.getUrl().equals(url)).collect(Collectors.toList());
			if (!accountDetailsList.isEmpty()) {
				String encrypted = encryptDecryptPassword.Encrypt(newPassword);
				result = (crud.updateAccountPassword(url, encrypted));
				System.out.println(result);
			} else {
				throw new InvalidUrlException("Oops! Entered URL is Invalid");
			}

		} catch (PasswordMismatchException | InvalidUrlException message) {
			System.out.println("No records present with that data");

		} catch (Exception e) {
			System.out.println("Other exception" + e.getMessage());

		}
		return result;
	}

	@Override
	public boolean deleteAccountByGroup(String groupName) {

		boolean isDeleted = false;
		try {
			List<Account> accountDetailsList = crud.getAccountList().stream()
					.filter(account -> account.getGroup().equals(groupName)).collect(Collectors.toList());

			if (!accountDetailsList.isEmpty()) {
				isDeleted = (crud.deleteAccountByGroupName(groupName));
				isDeleted = true;
			} else {
				throw new NoRecordFoundForGroup("Oops! No Record found for group");
			}

		} catch (NoRecordFoundForGroup message) {
			System.out.println(groupName + " group name doesn't exits in database.");

		}
		return isDeleted;
	}

	@Override
	public List<Account> modifyUrl(String url, String newUrl) {
		List<Account> result = new ArrayList<>();
		try {
			List<Account> accountDetailsList = crud.getAccountList().stream()
					.filter(account -> account.getUrl().equals(url)).collect(Collectors.toList());

			if (!accountDetailsList.isEmpty()) {
				result = (crud.updateAccountUrl(url, newUrl));
				System.out.println(result);
			} else {
				throw new InvalidUrlException("Oops! Entered URL is Invalid");
			}

		} catch (InvalidUrlException message) {
			System.out.println(url + " Entered URL doesn't exits in database.");

		}
		return result;
	}

	@Override
	public boolean deleteAccountByUrl(String url) {
		boolean isDeleted = false;
		try {
			List<Account> accountDetailsList = crud.getAccountList().stream()
					.filter(account -> account.getUrl().equals(url)).collect(Collectors.toList());

			if (!accountDetailsList.isEmpty()) {
				isDeleted = (crud.deleteAccountByUrl(url));
			} else {
				throw new InvalidUrlException("Oops! Entered URL is Invalid");
			}

		} catch (InvalidUrlException message) {
			System.out.println(url + " Entered URL doesn't exits in database.");

		}
		return isDeleted;
	}

	@Override
	public boolean getPassword( String url, String accountUsername) {
		boolean isUpdated = false;
		String temporary = null;
		try {
			List<Account> accountList = crud.getDecryptedPassword(url, accountUsername);
			if (!accountList.isEmpty()) {

				temporary = encrypt.getEncryptedPassword(accountList, url, accountUsername);
				if (!temporary.equals("")) {
					isUpdated = true;
					System.out.println("The Encrypted password is : " + temporary);

					String temporary2 = null;

					temporary2 = encrypt.getDecryptedPassword(accountList, url, accountUsername);

					System.out.println("The Decrypted password is : " + temporary2);
				} else {
					throw new InvalidUrlException("Oops! Entered URL is Invalid");
				}
			} else {
				throw new AccountDoesNotExistException("Oops! No account is present");
			}

		} catch (AccountDoesNotExistException | InvalidUrlException message) {
			System.out.println("Account doesn't exits in database.");
		}

		return isUpdated;
	}

	
	

}
