package com.epam.pmt.junittestcases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;
import com.epam.pmt.validation.ValidationUrl;

public class ValidationOfUserNamePasswordAndUrl {
	ValidationPassword validationPassword;
	ValidationUrl validationUrl;
	String userName;
	ValidateUserName validateUserName;

	@BeforeEach
	public void validation() {
		validateUserName = new ValidateUserName();
		validationPassword = new ValidationPassword();
		validationUrl = new ValidationUrl();
	}

	@Test

	public void ifCorrectUserName_PasswordAndUrlReturnTrue() {
		String inputPassword = "Manoj@123";
		String url = "https://www.geeksforgeeks.org";
		userName = "Manoj";
		assertTrue(validateUserName.isValidUserName(userName));
		assertTrue(validationPassword.validPassword(inputPassword));
		assertTrue(validationUrl.isValidURL(url));
	}

	@Test

	public void ifInCorrectUserName_PasswordAndUrlReturnFalse() {

		userName = " ";
		String password = "manoj";
		String url = "ww.demo";
		assertFalse(validateUserName.isValidUserName(userName));
		assertFalse(validationPassword.validPassword(password));
		assertFalse(validationUrl.isValidURL(url));
	}

	@Test

	public void ifInCorrectUserName_CorrectPasswordAndCorrectUrl() {

		userName = " ";
		String inputPassword = "Manoj@123";
		String url = "https://www.geeksforgeeks.org";
		assertFalse(validateUserName.isValidUserName(userName));
		assertTrue(validationPassword.validPassword(inputPassword));
		assertTrue(validationUrl.isValidURL(url));
	}

	@Test

	public void ifCorrectUserName_InCorrectPasswordAndCorrectUrl() {

		userName = "Manoj";
		String password = "manoj";
		String url = "https://www.geeksforgeeks.org";
		assertTrue(validateUserName.isValidUserName(userName));
		assertFalse(validationPassword.validPassword(password));
		assertTrue(validationUrl.isValidURL(url));
	}

	@Test

	public void ifCorrectUserName_CorrectPasswordAndInCorrectUrl() {

		userName = "Manoj";
		String inputPassword = "Manoj@123";
		String url = "ww.demo";
		assertTrue(validateUserName.isValidUserName(userName));
		assertTrue(validationPassword.validPassword(inputPassword));
		assertFalse(validationUrl.isValidURL(url));
	}

	@Test

	public void ifInCorrectUserName_InCorrectPasswordAndCorrectUrl() {

		userName = "Mj";
		String inputPassword = "manoj@123";
		String url = "https://www.geeksforgeeks.org";
		assertFalse(validateUserName.isValidUserName(userName));
		assertFalse(validationPassword.validPassword(inputPassword));
		assertTrue(validationUrl.isValidURL(url));
	}

	@Test

	public void ifInCorrectUserName_CorrectPasswordAndInCorrectUrl() {

		userName = "Mj";
		String inputPassword = "Manoj@123";
		String url = "www.geeksforgeeks.org";
		assertFalse(validateUserName.isValidUserName(userName));
		assertTrue(validationPassword.validPassword(inputPassword));
		assertFalse(validationUrl.isValidURL(url));
	}

	@Test

	public void ifCorrectUserName_InCorrectPasswordAndInCorrectUrl() {

		userName = "Manojj";
		String inputPassword = "noj@123";
		String url = "www.geeksforgeeks.org";
		assertTrue(validateUserName.isValidUserName(userName));
		assertFalse(validationPassword.validPassword(inputPassword));
		assertFalse(validationUrl.isValidURL(url));
	}
}
