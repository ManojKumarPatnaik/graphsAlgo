package com.epam.pmt.servicelayer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pmt.database.CrudOperationsDbImpl;
import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.LoginFirstException;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;
import com.epam.pmt.presentationlayer.CurrentAccount;
import com.epam.pmt.utils.ConstantsUtils;
import com.epam.pmt.validation.AccountValidation;

@Service
public class CrudOperationsServiceImpl implements CrudOperationsService {
	@Autowired
	CrudOperationsDbImpl crudOperationsDao;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	EncryptionAndDecryption encrypt;
	@Autowired
	AccountValidation accountValidation;

	@Override
	public List<Account> getAccountByGroupName(String groupName) throws NoGroupFoundForAccount {
		List<Account> accountDetailsList = (crudOperationsDao.listAccountByGroupName(groupName));
		if (accountDetailsList.isEmpty()) {
			throw new NoGroupFoundForAccount("No group present with that name");
		}
		return accountDetailsList;
	}

	@Override
	public boolean deleteAccountByGroup(String groupName) throws NoRecordFoundForGroup {
		boolean isDeletedGroup = false;
		List<Account> accountDetailsList = crudOperationsDao.getAccountList().stream()
				.filter(account -> account.getGroup().equals(groupName)).collect(Collectors.toList());

		isDeletedGroup = crudOperationsDao.deleteAccountByGroupName(groupName);
		if (accountDetailsList.isEmpty()) {
			throw new NoRecordFoundForGroup("Oops! No Record found for group");
		}

		return isDeletedGroup;
	}

	@Override
	public boolean deleteAccountByUrl(String url) throws InvalidUrlException {
		boolean isDeleted = false;
		List<Account> accountDetailsList = crudOperationsDao.getAccountList().stream()
				.filter(account -> account.getUrl().equals(url)).collect(Collectors.toList());

		if (!accountDetailsList.isEmpty()) {
			isDeleted = (crudOperationsDao.deleteAccountByUrl(url));
		} else {
			throw new InvalidUrlException(ConstantsUtils.URLMESSAGE);
		}

		return isDeleted;
	}

	@Override
	public String getPassword( String accountUsername) {
		String decryptPassword = null;
		try {
			decryptPassword = encrypt.getDecryptedPassword(crudOperationsDao.getDecryptedPasswordList(accountUsername),  accountUsername);
			if (decryptPassword.isEmpty()) {
				throw new AccountDoesNotExistException("Oops! No account is present");
			}
			
		} catch (AccountDoesNotExistException message) {
			ConstantsUtils.logger.info(message);
		}
		return decryptPassword;
	}

	@Override
	public boolean addAccount(Account account) {
		boolean isAdd = false;
		MasterUser current = CurrentAccount.getInstance().getCurrentUser();
		account.setMasterUser(current);
		if (current == null) {
			throw new LoginFirstException("Please login first!");

		}
		isAdd = crudOperationsDao.add(account);
		return isAdd;
	}

	@Override
	public List<Account> viewAllAccounts() {
		List<Account> accountDetailsList = null;
		try {
			accountDetailsList = crudOperationsDao.getAccountList();

			if (accountDetailsList.isEmpty()) {
				throw new AccountDoesNotExistException("No Accounts present with that user name");
			}
		} catch (AccountDoesNotExistException message) {
			ConstantsUtils.logger.info(message);
		}
		return accountDetailsList;
	}

	@Override
	public List<MasterUser> viewAllUsers() throws AccountDoesNotExistException {

		List<MasterUser> usersDetailsList = crudOperationsDao.getAllUsers();

		if (usersDetailsList.isEmpty()) {
			throw new AccountDoesNotExistException("No Users present in database. ");
		}

		return usersDetailsList;
	}

	@Override
	public Account getAccountById(int id) {

		return crudOperationsDao.getAccountById(id);
	}

	@Override
	public void updateAccount(Account account) {
		crudOperationsDao.updateAccountDetails(account.getAccountId(), account.getUrl(), account.getUsername(),
				account.getPassword(), account.getGroup());
	}

}
