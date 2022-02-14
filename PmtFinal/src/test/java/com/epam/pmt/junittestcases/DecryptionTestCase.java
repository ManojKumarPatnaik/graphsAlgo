package com.epam.pmt.junittestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;

public class DecryptionTestCase {
	EncryptDecryptPassword decrypt;
	
	@BeforeEach
	public void test() {
		decrypt = new EncryptDecryptPassword();
	}
	
	
	@Test

	public void testPasswordIsDecryptedReturnTrue() {
		String password = "CKX5k3qZMv94/mthvcZIpw==";
		assertEquals("Manoj@123", decrypt.Decrypt(password));
	}
	@Test

	public void testPasswordIsDecrypted() {
		String password = "CKX5k3qZMv94/mthvcZIpw==";
		Assertions.assertNotEquals("", decrypt.Decrypt(password));
	}
	@Test
	public void testEmptyPasswordIsEncryptedReturnTrue() {
		String password = "07RI3s/vhYkKf2GvA1kY/w==";
		assertEquals("", decrypt.Decrypt(password));
	}
	@Test
	public void testEmptyPasswordIsEncrypted() {
		String password = "07RI3s/vhYkKf2GvA1kY/w==";
		Assertions.assertNotEquals("Manoj", decrypt.Decrypt(password));
	}

}
