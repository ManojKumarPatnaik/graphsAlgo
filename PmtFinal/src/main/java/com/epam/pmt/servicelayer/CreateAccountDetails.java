package com.epam.pmt.servicelayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import com.epam.pmt.entity.Account;
@Service
public class CreateAccountDetails {
	public static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
	public static EntityManager emanager=emFactory.createEntityManager();
	
	public boolean add(Account account) {
		
		System.out.println(account);
		emanager.getTransaction().begin();
		emanager.persist(account);
		emanager.getTransaction().commit();
		
		
		return true;
		
	}
	

}




















//	 AccountDataBase data;
//		data.add(account);
