package com.epam.pmt.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epam.pmt.entity.MasterUser;

public interface MasterUserRepo  extends CrudRepository<MasterUser, Integer>{
	
	boolean existsByUsername(String username);
	
	Optional<MasterUser> findByUsernameAndPassword(String username,String password);
}
