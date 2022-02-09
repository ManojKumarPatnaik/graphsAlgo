package com.epam.pmt.validation;

import org.springframework.stereotype.Component;

import com.epam.pmt.exceptions.InvalidUserName;

@Component
public class ValidateUserName {
	public boolean isValidUserName(String username) throws InvalidUserName{

		boolean result = false;
		String regex = "^[a-zA-Z][a-zA-Z_$]{3,}$";
		if (username.matches(regex)) {
			result = true;
		} else {
			throw new InvalidUserName("Invalid User Name");
		}

		return result;
	}

}
