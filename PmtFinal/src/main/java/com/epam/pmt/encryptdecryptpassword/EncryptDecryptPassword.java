package com.epam.pmt.encryptdecryptpassword;

import java.util.Base64;

import org.springframework.stereotype.Component;
@Component
public class EncryptDecryptPassword {

	public String Encrypt(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	public String Decrypt(String encryptedPassword) {
		return new String(Base64.getDecoder().decode(encryptedPassword));
	}


}
