package com.epam.pmt.encryptdecryptpassword;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUserName;

@Component
public class EncryptionAndDecryption {
	@Autowired
	private ApplicationContext context;

	public String getDecryptedPassword(List<Account> filterAccountDetails, String accountUserName) throws InvalidUserName {
		String password=context.getBean(EncryptDecryptPassword.class)
				.decrypt(filterAccountDetails.stream().filter(account -> account.getUsername().equals(accountUserName))
						.map(Account::getPassword).collect(Collectors.toList()).get(0));
		if(password.isEmpty()) {
			throw new InvalidUserName("Invalid user Name.");
		}
		return password;
	}

}
