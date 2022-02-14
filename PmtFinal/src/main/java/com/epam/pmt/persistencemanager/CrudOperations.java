package com.epam.pmt.persistencemanager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Repository;

import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
@Repository
public class CrudOperations {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(CrudOperations.class);

	@SuppressWarnings("unchecked")
	public  List<Account> getAccountList() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		 EntityManager emanager = emFactory.createEntityManager();
		List<Account> accountList = emanager.createQuery("from Account").getResultList();
		return accountList;

	}

	@SuppressWarnings("unchecked")
	public List<MasterUser> getAllUsers() {
		 EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		 EntityManager emanager = emFactory.createEntityManager();
		return emanager.createQuery("from MasterUser").getResultList();

	}
	


	@SuppressWarnings("unchecked")
	public  List<Account> listAccountByGroupName( String group) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		EntityManager emanager = emFactory.createEntityManager();
		
		emanager.getTransaction().begin();
		
		List<Account>account = emanager.createQuery("select acc from Account acc where acc.group=:group")
				.setParameter("group", group).getResultList();
		emanager.getTransaction().commit();
		
		logger.info("List of Account Details on base of group Name");
		return account;
	}
	


	@SuppressWarnings("unchecked")
	public List<Account> updateAccountByGroupName( String group, String newgroup) {
		 EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		 EntityManager emanager = emFactory.createEntityManager();
		emanager.getTransaction().begin();
		emanager.createQuery("update Account account set account.group=:newgroup where account.group=:group")
				.setParameter("newgroup", newgroup).setParameter("group", group).executeUpdate();
		List<Account> list=emanager.createQuery("select account from Account account where account.group=:newgroup")
		.setParameter("newgroup", newgroup).getResultList();
		emanager.getTransaction().commit();
		logger.info("Group Name updated Succussfully");
		return list;
	}

	public boolean deleteAccountByGroupName( String group) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		EntityManager emanager = emFactory.createEntityManager();
		emanager.getTransaction().begin();
		
		int deletedAccount=emanager.createQuery("delete from Account account where account.group=:group").setParameter("group", group)
				.executeUpdate();
		emanager.getTransaction().commit();
		logger.info("Account Deleted Succussfully on base of group Name   {} ",deletedAccount);
		return true;
	}
	@SuppressWarnings("unchecked")
	public List<Account> updateAccountPassword( String url, String newpassword) {
		 EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		 EntityManager emanager = emFactory.createEntityManager();
		emanager.getTransaction().begin();
		emanager.createQuery("update Account account set account.password=:newpassword where account.url=:url")
				.setParameter("newpassword", newpassword).setParameter("url", url).executeUpdate();
		List<Account> list=emanager.createQuery("select account from Account account where account.password=:newpassword")
				.setParameter("newpassword", newpassword).getResultList();
		emanager.getTransaction().commit();
		logger.info("Password updated Succussfully");
		return list;
	}

	@SuppressWarnings("unchecked")
	public  List<Account> updateAccountUrl( String url, String newUrl) {
		 EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		 EntityManager emanager = emFactory.createEntityManager();
		emanager.getTransaction().begin();
		emanager.createQuery("update Account account set account.url=:newUrl where account.url=:url")
				.setParameter("newUrl", newUrl).setParameter("url", url).executeUpdate();
		emanager.getTransaction().commit();
		List<Account> list=emanager.createQuery("select account from Account account where account.url=:newUrl")
				.setParameter("newUrl", newUrl).getResultList();
		logger.info("Url updated Succussfully");
		return list;
	}

	public  boolean deleteAccountByUrl( String url) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		EntityManager emanager = emFactory.createEntityManager();
		emanager.getTransaction().begin();
		emanager.createQuery("delete from Account account where account.url=:url").setParameter("url", url)
		.executeUpdate();
		emanager.getTransaction().commit();
		logger.info("Account Deleted Succussfully on base of Url");
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Account> getDecryptedPassword( String url, String username) {
		List<Account> account=new ArrayList<>();
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
		 EntityManager emanager = emFactory.createEntityManager();
		emanager.getTransaction().begin();
		account= emanager.createQuery("select acc from Account acc  where acc.url=:url and acc.username=:username")
				.setParameter("url", url).setParameter("username", username).getResultList();
		emanager.getTransaction().commit();
		return account;
	}

}
