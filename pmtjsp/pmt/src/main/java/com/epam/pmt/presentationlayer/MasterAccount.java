package com.epam.pmt.presentationlayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.entity.MasterUser;
@Component
public class MasterAccount {
	
	@Autowired
	EntityManagerFactory entityManagerFactory ;
	
	public boolean addMasterUser(String username,String password) {
		
		EntityManager emanager=entityManagerFactory.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(new MasterUser(username,password));
		emanager.getTransaction().commit();
		emanager.close();
		return true;
	}

}
