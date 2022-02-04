package com.epam.pmt.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.InvalidLoginDetail;
import com.epam.pmt.servicelayer.PasswordManagementServiceImpl;

@Component
public class Login {
	@Autowired
	PasswordManagementServiceImpl crudOperationsServiceImpl;
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Login.class);

	public boolean validateLoginDetails(String user, String password) throws InvalidLoginDetail {
		List<MasterUser> userlist = crudOperationsServiceImpl.viewAllUsers();
		List<MasterUser> newlist = userlist.stream()
				.filter(name -> user.equals(name.getUsername()) && password.equals(name.getPassword()))
				.collect(Collectors.toList());

		if (newlist.isEmpty()) {
			throw new InvalidLoginDetail("Invalid login details");
		}
		logger.info("Login Successfully");
		return true;
	}

}
