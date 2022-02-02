package com.epam.pmt.validation;

import org.springframework.stereotype.Component;

import com.epam.pmt.exceptions.PasswordMismatchException;

@Component
public class ValidationPassword {

	public boolean validPassword(String password) {
		String validatePasword = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		boolean result=false;
		
		if(password.matches(validatePasword)) {
			result=true;
		}
		
		else {
			throw new PasswordMismatchException("Password must contains one upper case, one lower case and one digit");
		}
		return result;
	}
}
