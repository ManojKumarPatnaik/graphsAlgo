package com.epam.pmt.encryptdecryptpassword;

import java.util.Base64;

import org.springframework.stereotype.Component;
@Component
public class EncryptDecryptPassword {

	public String encrypt(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	public String decrypt(String encryptedPassword) {
		return new String(Base64.getDecoder().decode(encryptedPassword));
	}


}
