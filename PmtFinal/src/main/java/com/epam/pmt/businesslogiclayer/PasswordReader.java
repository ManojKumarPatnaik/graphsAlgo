package com.epam.pmt.businesslogiclayer;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;

public class PasswordReader {

	public String getPassword(List<Account> filterAccountDetails, String url, String accountUserName) throws AccountDoesNotExistException, InvalidUrlException {
		filterAccountDetails.stream().filter(account -> account.getUrl().equals(url) && account.getUsername().equals(accountUserName))
				.peek(account -> account.getPassword()).collect(Collectors.toList());

		return "";
	}

	public String getDecryptedPassword(List<Account> filterAccountDetails, String url, String accountUserName)throws AccountDoesNotExistException, InvalidUrlException {
		List<String> newlist = filterAccountDetails.stream()
				.filter(account -> account.getUrl().equals(url) && account.getUsername().equals(accountUserName))
				.map(Account::getDecryptedPassword).collect(Collectors.toList());
		return newlist.get(0);
	}

}
