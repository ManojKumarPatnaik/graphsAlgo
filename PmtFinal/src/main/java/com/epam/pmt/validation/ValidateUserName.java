package com.epam.pmt.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
@Component
public class ValidateUserName {
	
	public boolean isValidUserName(String UserName) {
		String regex = "^[a-zA-Z][a-zA-Z_$]{3,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(UserName);
		return matcher.matches();
	}

}
