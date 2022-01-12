package com.epam.pmt.validation;

public class ValidationPassword {
	public boolean validPassword(String password) {
		try {
			boolean hasNumber = false, hasCapitalLetter = false, hasLowerCase = false;
			for (int i = 0; i <= password.length(); i++) {

				char character = password.charAt(i);
				if (Character.isDigit(character)) {
					hasNumber = true;
				} else if (Character.isUpperCase(character)) {
					hasCapitalLetter = true;

				} else if (Character.isLowerCase(character)) {
					hasLowerCase = true;
				}
				if (hasNumber && hasCapitalLetter && hasLowerCase) {
					return true;
				}
			}
			return true;
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Please Follow the above validations & Try Again ... Thank You");

		}
		return false;
	}
}
