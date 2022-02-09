package com.epam.pmt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;

@Transactional
public interface AccountRepo extends CrudRepository<Account, Integer> {

	List<Account> findByMasterUser(MasterUser masterUser);

	List<Account> findByUsernameAndMasterUser(String username, MasterUser user);

	List<Account> findByGroupAndMasterUser(String group, MasterUser user);
	
	List<Account> findByUrlAndMasterUser(String url, MasterUser user);

	@Modifying
	void deleteByUrlAndMasterUser( String url,  MasterUser user);

	@Modifying
	void deleteByGroupAndMasterUser(String group, MasterUser user);

	
	
}
