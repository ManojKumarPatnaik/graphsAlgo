package com.epam.pmt.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.LoginFirstException;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;
import com.epam.pmt.repo.AccountRepo;
import com.epam.pmt.repo.MasterUserRepo;
import com.epam.pmt.utils.ConstantsUtils;
import com.epam.pmt.utils.CurrentAccount;
import com.epam.pmt.validation.AccountValidation;

@Service
public class PasswordManagementServiceImpl implements PasswordManagementService {
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	EncryptionAndDecryption encrypt;
	@Autowired
	AccountValidation accountValidation;
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	MasterUserRepo masterUserRepo;

	@Override
	public List<Account> getAccountByGroupName(String groupName) throws NoGroupFoundForAccount {
		List<Account> accountDetailsList = accountRepo.findByGroupAndMasterUser(groupName, CurrentAccount.getInstance().getCurrentUser());
		if (accountDetailsList.isEmpty()) {
			throw new NoGroupFoundForAccount("No group present with that name");
		}
		return accountDetailsList;
	}

	@Override
	public void deleteAccountByGroup(String groupName) throws NoRecordFoundForGroup {

		accountRepo.deleteByGroupAndMasterUser(groupName, CurrentAccount.getInstance().getCurrentUser());

	}

	@Override
	public void deleteAccountByUrl(String url) throws InvalidUrlException {

		accountRepo.deleteByUrlAndMasterUser(url, CurrentAccount.getInstance().getCurrentUser());

	}

	@Override
	public String getPassword( String accountUsername) throws AccountDoesNotExistException{
		String decryptPassword = null;
		try {
			decryptPassword = encrypt.getDecryptedPassword(accountRepo.findByUsernameAndMasterUser(accountUsername, CurrentAccount.getInstance().getCurrentUser()),  accountUsername);
			if (decryptPassword.isEmpty()) {
				throw new AccountDoesNotExistException("Oops! No account is present");
			}
			
		} catch (AccountDoesNotExistException message) {
			ConstantsUtils.logger.info(message);
		}
		return decryptPassword;
	}

	@Override
	public boolean addAccount(Account account) throws  LoginFirstException{
	
		MasterUser current = CurrentAccount.getInstance().getCurrentUser();
		account.setMasterUser(current);
		if (current == null) {
			throw new LoginFirstException("Please login first!");

		}
		accountRepo.save(account);
		return true;
	}

	@Override
	public List<Account> viewAllAccounts() {
		List<Account> accountDetailsList = null;
		try {
			accountDetailsList = accountRepo.findByMasterUser(CurrentAccount.getInstance().getCurrentUser());

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

		List<MasterUser> usersDetailsList = (List<MasterUser>) masterUserRepo.findAll();

		if (usersDetailsList.isEmpty()) {
			throw new AccountDoesNotExistException("No Users present in database. ");
		}

		return usersDetailsList;
	}

	public boolean addUser(MasterUser masterUser) {
		
		masterUserRepo.save(masterUser);
		return true;
	}
	public Account getAccountById(int id) {
		Optional<Account> accountDetails = accountRepo.findById(id);
		Account account = null;
		if (accountDetails.isPresent()) {
			account = accountDetails.get();
		}
		return account;
	}

	@Override
	public void updateAccount(Account account) {
		account.setMasterUser(CurrentAccount.getInstance().getCurrentUser());
		accountRepo.save(account);
	}

}
