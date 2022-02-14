package com.epam.pmt.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.InvalidLoginDetail;
import com.epam.pmt.exceptions.MasterUserAlreadyExistsException;
import com.epam.pmt.exceptions.MasterUsersDoesNotExistException;
import com.epam.pmt.repo.MasterUserRepo;
@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	MasterUserRepo masterUserRepo;
	
	@Override
	public List<MasterUser> viewAllUsers() throws MasterUsersDoesNotExistException {

		List<MasterUser> usersDetailsList = (List<MasterUser>) masterUserRepo.findAll();

		if (usersDetailsList.isEmpty()) {
			throw new MasterUsersDoesNotExistException("No Users present in database. ");
		}

		return usersDetailsList;
	}
	@Override
	public MasterUser addUser(MasterUser user) throws MasterUserAlreadyExistsException{
		MasterUser masterUser=null;
		if (masterUserRepo.existsByUsername(user.getUsername())) {
			throw new MasterUserAlreadyExistsException("MasterUser Already Exists");
		}else {
			masterUser=masterUserRepo.save(user);
		}
		
		return masterUser;
	}
	@Override
	public MasterUser getMasterUserById(int id) {
		Optional<MasterUser> userDetails = masterUserRepo.findById(id);
		MasterUser user = null;
		if (userDetails.isPresent()) {
			user = userDetails.get();
		}
		return user;
	}
	
	@Override
	public boolean validateLoginDetails(String user, String password) throws InvalidLoginDetail {
		boolean isValid=false;
		Optional<MasterUser> currentUser = masterUserRepo.findByUsernameAndPassword(user, password);
		if (currentUser.isPresent()) {
			isValid=true;
		}else {
			throw new InvalidLoginDetail("Invalid login details");
			
		}
		return isValid;
	}

	

}
