package com.epam.pmt.testcases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.validation.ValidationPassword;
import com.epam.pmt.validation.ValidationUrl;

public class ValidationOfPasswordAndUrlTestCases {
	ValidationPassword validationPassword;
	ValidationUrl validationUrl;

	@BeforeEach
	public void validation() {
		validationPassword = new ValidationPassword();
		validationUrl = new ValidationUrl();
	}

	@Test

	public void ifInCorrectPasswordAndUrlReturnFalse() {
		String password = "manoj";
		String url = "ww.demo";
		assertFalse(validationPassword.validPassword(password));
		assertFalse(validationUrl.isValidURL(url));
	}

	@Test

	public void ifCorrectPasswordAndUrlReturnTrue() {
		String inputPassword = "Manoj@123";
		String url = "https://www.geeksforgeeks.org";
		assertTrue(validationPassword.validPassword(inputPassword));
		assertTrue(validationUrl.isValidURL(url));
	}

	@Test

	public void ifInCorrectPasswordAndCorrectUrl() {
		String password = "manoj";
		String url = "https://www.geeksforgeeks.org";
		assertFalse(validationPassword.validPassword(password));
		assertTrue(validationUrl.isValidURL(url));
	}

	@Test

	public void ifCorrectPasswordAndInCorrectUrl() {
		String password = "Demo@1234";
		String url = "www.geeksforgeeks.org";
		assertTrue(validationPassword.validPassword(password));
		assertFalse(validationUrl.isValidURL(url));
	}

	@Test

	public void ifNullUrl() {
		String password = "Demo@1234";
		String url = null;
		assertTrue(validationPassword.validPassword(password));
		assertFalse(validationUrl.isValidURL(url));
	}

	@Test

	public void ifNullPassword() {
		String password = "";
		String url = "";
		assertFalse(validationPassword.validPassword(password));
		assertFalse(validationUrl.isValidURL(url));
	}

	@Test

	public void ifPasswordReturnsTrue() {
		String password = "Manoj@1";
		String url = "";
		Assertions.assertEquals(true, validationPassword.validPassword(password));
		assertFalse(validationUrl.isValidURL(url));
	}

}
