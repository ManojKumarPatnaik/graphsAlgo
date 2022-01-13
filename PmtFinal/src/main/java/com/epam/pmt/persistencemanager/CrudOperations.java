package com.epam.pmt.persistencemanager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;

public class CrudOperations {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(CrudOperations.class);
	public static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
	public static EntityManager emanager = emFactory.createEntityManager();

	public static List<Account> getAccountList() {
		List<Account> accountList = emanager.createQuery("from Account").getResultList();
		return accountList;

	}

	public List<MasterUser> getAllUsers() {

		return emanager.createQuery("from MasterUser").getResultList();

	}

	public static void deleteAccountByGroupName(List<Account> account, String group) {
		emanager.getTransaction().begin();
		emanager.createQuery("delete from Account account where account.group=:group").setParameter("group", group)
				.executeUpdate();
		emanager.getTransaction().commit();
		logger.info("Account Deleted Succussfully on base of group Name");
	}

	public static void deleteAccountByUrl(List<Account> account, String url) {
		emanager.getTransaction().begin();
		emanager.createQuery("delete from Account account where account.url=:url").setParameter("url", url)
				.executeUpdate();
		emanager.getTransaction().commit();
		logger.info("Account Deleted Succussfully on base of Url");
	}

	public static void ListAccountByGroupName(List<Account> account, String group) {
		emanager.getTransaction().begin();
		account = emanager.createQuery("select acc from Account acc where acc.group=:group")
				.setParameter("group", group).getResultList();
		System.out.println(account);
		emanager.getTransaction().commit();
		logger.info("List of Account Details on base of group Name");
	}

	public static void updateAccountByGroupName(List<Account> account, String group, String newgroup) {
		emanager.getTransaction().begin();
		emanager.createQuery("update Account account set account.group=:newgroup where account.group=:group")
				.setParameter("newgroup", newgroup).setParameter("group", group).executeUpdate();
		emanager.getTransaction().commit();
		logger.info("Group Name updated Succussfully");
	}

	public static void updateAccountPassword(List<Account> account, String url, String newpassword) {
		emanager.getTransaction().begin();
		emanager.createQuery("update Account account set account.password=:newpassword where account.url=:url")
				.setParameter("newpassword", newpassword).setParameter("url", url).executeUpdate();
		emanager.getTransaction().commit();
		logger.info("Password updated Succussfully");
	}

	public static void updateAccountUrl(List<Account> account, String url, String newUrl) {
		emanager.getTransaction().begin();
		emanager.createQuery("update Account account set account.url=:newUrl where account.url=:url")
				.setParameter("newUrl", newUrl).setParameter("url", url).executeUpdate();
		emanager.getTransaction().commit();
		logger.info("Url updated Succussfully");
	}

	public static void getDecryptedPassword(List<Account> account, String url, String username) {
		emanager.getTransaction().begin();
		account = emanager.createQuery("select acc from Account acc  where acc.url=:url and acc.username=:username")
				.setParameter("url", url).setParameter("username", username).getResultList();
		emanager.getTransaction().commit();
	}

}
