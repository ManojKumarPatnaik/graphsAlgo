package com.epam.pmt.encryptdecryptpassword;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.epam.pmt.entity.Account;
@Component
public class EncryptionAndDecryption {
	@Autowired
	private ApplicationContext context;
	public String getEncryptedPassword(List<Account> filterAccountDetails, String url, String accountUserName) {
		List<String> newlist =filterAccountDetails.stream().filter(account -> account.getUrl().equals(url) && account.getUsername().equals(accountUserName))
				.map(Account::getPassword).collect(Collectors.toList());
		return newlist.get(0);
	}
	public String getDecryptedPassword(List<Account> filterAccountDetails, String url, String accountUserName) {
//		String encrypted = getEncryptedPassword( filterAccountDetails,  url,  accountUserName);
//				filterAccountDetails.stream()
//				.filter(account -> account.getUrl().equals(url) && account.getUsername().equals(accountUserName))
//				.map(Account::getPassword).collect(Collectors.toList());
		return context.getBean(EncryptDecryptPassword.class).Decrypt(getEncryptedPassword( filterAccountDetails,  url,  accountUserName));
	}

}
