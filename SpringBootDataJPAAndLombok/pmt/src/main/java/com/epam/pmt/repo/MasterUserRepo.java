package com.epam.pmt.repo;

import org.springframework.data.repository.CrudRepository;

import com.epam.pmt.entity.MasterUser;

public interface MasterUserRepo  extends CrudRepository<MasterUser, Integer>{
	
	
}
