package com.epam.pmt.junittestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;

public class EncryptionTestCase {
	EncryptDecryptPassword encrypt;
	@BeforeEach
	public void test() {
		 encrypt = new EncryptDecryptPassword();
	}
	@Test

	public void testPasswordIsEncryptedReturnTrue() {
		String password = "Manoj@123";
		
		assertEquals("CKX5k3qZMv94/mthvcZIpw==", encrypt.Encrypt(password));
	}
	@Test
	public void testEmptyPasswordIsEncryptedReturnTrue() {
		String password = "";
		assertEquals("07RI3s/vhYkKf2GvA1kY/w==", encrypt.Encrypt(password));
	}
	
	@Test
	public void testNullPasswordIsEncrypted() {
		String password = null;
		Assertions.assertNull(null, encrypt.Encrypt(password));
	}

}
