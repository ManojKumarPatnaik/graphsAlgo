package com.epam.pmt.testcases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.validation.ValidateUserName;

public class ValidationOfUserName {
	String userName;
	ValidateUserName validateUserName;

	@BeforeEach
	public void userNameValidation() {
		validateUserName = new ValidateUserName();
	}

	@Test
	public void ifInvalidUserNameReturnsFalse() {
		userName = " ";
		assertFalse(validateUserName.isValidUserName(userName));

	}

	@Test
	public void ifValidUserNameReturnsTrue() {
		userName = "Manoj";
		assertTrue(validateUserName.isValidUserName(userName));

	}

}
