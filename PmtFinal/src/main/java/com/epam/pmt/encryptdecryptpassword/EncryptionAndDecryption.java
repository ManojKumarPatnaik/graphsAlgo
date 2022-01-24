package com.epam.pmt.encryptdecryptpassword;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
@Component
public class EncryptionAndDecryption {
	public String getEncryptedPassword(List<Account> filterAccountDetails, String url, String accountUserName) throws AccountDoesNotExistException, InvalidUrlException {
		List<String> newlist =filterAccountDetails.stream().filter(account -> account.getUrl().equals(url) && account.getUsername().equals(accountUserName))
				.map(Account::getPassword).collect(Collectors.toList());
		return newlist.get(0);
	}
	public String getDecryptedPassword(List<Account> filterAccountDetails, String url, String accountUserName)throws AccountDoesNotExistException, InvalidUrlException {
		List<String> newlist = filterAccountDetails.stream()
				.filter(account -> account.getUrl().equals(url) && account.getUsername().equals(accountUserName))
				.map(Account::getDecryptedPassword).collect(Collectors.toList());
		return newlist.get(0);
	}

}
