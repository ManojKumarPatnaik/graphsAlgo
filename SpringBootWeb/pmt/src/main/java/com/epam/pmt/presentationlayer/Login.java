package com.epam.pmt.presentationlayer;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.database.CrudOperationsDbImpl;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.InvalidLoginDetail;

@Component
public class Login {
	MasterUser currentUser;
	@Autowired
	CrudOperationsDbImpl crud;
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Login.class);
	private static final Scanner scanner = new Scanner(System.in);

	public void login() {
		logger.info("Enter Master User Name  ");
		String username2 = scanner.next();
		logger.info("Enter MasterPassword ");

		String password2 = scanner.next();
		
		logger.info(username2,"User Name  {}  Password" );
		try {
		
		
		if(validateLoginDetails(username2,password2)) {
			currentUser = crud.getAllUsers().stream()
					.filter(account -> account.getUsername().equals(username2) && account.getPassword().equals(password2))
					.collect(Collectors.toList()).get(0);
			CurrentAccount.getInstance().setCurrentUser(currentUser);
			
			logger.info("Logined successfully");
		}
		}catch(InvalidLoginDetail message) {
			logger.info( message);
		}
		
		
	}

	public boolean validateLoginDetails(String user,String  password) {
		boolean result=false;
		List<MasterUser> userlist=crud.getAllUsers();
		List<MasterUser> newlist=userlist.stream().filter(name->user.equals(name.getUsername())&&password.equals(name.getPassword())).collect(Collectors.toList());
		
		if(!newlist.isEmpty()) {
			result=true;
		}
		else{
			throw new InvalidLoginDetail("Invalid login details");
		}
		
		
		return result;
	}

	
}
