package com.epam.pmt.servicelayer;

import java.util.List;

import com.epam.pmt.entity.MasterUser;

public interface UserService {

	List<MasterUser> viewAllUsers();

	MasterUser addUser(MasterUser user);

	MasterUser getMasterUserById(int id);
	
	boolean validateLoginDetails(String user, String password);

}
