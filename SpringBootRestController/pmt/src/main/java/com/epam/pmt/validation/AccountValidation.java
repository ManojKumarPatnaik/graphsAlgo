package com.epam.pmt.validation;

import org.springframework.stereotype.Component;

import com.epam.pmt.exceptions.InvalidGroupNameException;
import com.epam.pmt.exceptions.InvalidUrlException;

@Component
public class AccountValidation {

	public boolean isValidURL(String url) throws InvalidUrlException {
		String regex = "((http|https)://)(www.)?" + "[a-zA-Z0-9@:%_\\+~#?&=]" + "{2,256}\\.[a-z]"
				+ "{2,6}\\b([-a-zA-Z0-9@:%" + "_\\+~#?&=]*)";

		boolean result = false;
		if (url.matches(regex)) {
			result = true;
		}

		else {
			throw new InvalidUrlException("Invalid URL");
		}
		return result;

	}

	public boolean isValidGroupName(String group) throws InvalidGroupNameException {
		boolean result = false;
		String regex = "^[a-zA-Z][a-zA-Z_$]{3,}$";
		if (group.matches(regex)) {
			result = true;
		} else {
			throw new InvalidGroupNameException("Invalid Group Name");
		}
		return result;
	}

}
