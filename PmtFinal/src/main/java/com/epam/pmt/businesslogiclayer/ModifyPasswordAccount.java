package com.epam.pmt.businesslogiclayer;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.PasswordMismatchException;

public class ModifyPasswordAccount {
	public String modifyUrl(List<Account> filterAccountDetails, String url, String newUrl) throws InvalidUrlException{
		filterAccountDetails.stream().filter(account -> account.getUrl().equals(url)).peek(account -> account.setUrl(newUrl))
				.collect(Collectors.toList());
		return "URL Modified successfully";
	}


	public String modifyPassword(List<Account> filterAccountDetails, String url, String newPassword) throws PasswordMismatchException {
		filterAccountDetails.stream().filter(account -> account.getUrl().equals(url)).peek(account -> account.setPassword(newPassword))
				.collect(Collectors.toList());
		return "Password Modified successfully";
	}


}
