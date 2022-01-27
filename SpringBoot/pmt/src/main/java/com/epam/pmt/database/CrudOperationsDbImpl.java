package com.epam.pmt.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.presentationlayer.CurrentAccount;

@Repository
public class CrudOperationsDbImpl implements CrudOperationsDb {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(CrudOperationsDbImpl.class);

	public boolean add(Account account) {
		EntityManager emanager = entityManagerFactory.createEntityManager();
		System.out.println(account);
		emanager.getTransaction().begin();
		emanager.persist(account);
		emanager.getTransaction().commit();
		emanager.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAccountList() {
		MasterUser user=CurrentAccount.getInstance().getCurrentUser();
		EntityManager emanager = entityManagerFactory.createEntityManager();
		return emanager.createQuery("select account from Account account where account.masterUser= :user")
				.setParameter("user", user).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<MasterUser> getAllUsers() {
		EntityManager emanager = entityManagerFactory.createEntityManager();
		return emanager.createQuery("from MasterUser").getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Account> listAccountByGroupName( String group) {
		MasterUser user=CurrentAccount.getInstance().getCurrentUser();
		EntityManager emanager = entityManagerFactory.createEntityManager();

		emanager.getTransaction().begin();

		List<Account> account = emanager
				.createQuery("select acc from Account acc where acc.group=:group and acc.masterUser= :user")
				.setParameter("group", group).setParameter("user", user).getResultList();
		emanager.getTransaction().commit();
		emanager.close();

		logger.info("List of Account Details on base of group Name");
		return account;
	}

	@SuppressWarnings("unchecked")
	public List<Account> updateAccountByGroupName( String group, String newgroup) {
		MasterUser user=CurrentAccount.getInstance().getCurrentUser();
		EntityManager emanager = entityManagerFactory.createEntityManager();
		emanager.getTransaction().begin();
		int upadtedGroup = emanager.createQuery(
				"update Account account set account.group=:newgroup where account.group=:group and account.masterUser= :user")
				.setParameter("newgroup", newgroup).setParameter("group", group).setParameter("user", user)
				.executeUpdate();
		List<Account> list = emanager.createQuery("select account from Account account where account.group=:newgroup and account.masterUser= :user")
				.setParameter("newgroup", newgroup).setParameter("user", user).getResultList();
		emanager.getTransaction().commit();
		emanager.close();

		logger.info("Group Name updated Succussfully, count = {} ", upadtedGroup);
		return list;
	}

	public boolean deleteAccountByGroupName( String group) {
		MasterUser user=CurrentAccount.getInstance().getCurrentUser();
		EntityManager emanager = entityManagerFactory.createEntityManager();
		emanager.getTransaction().begin();

		int deletedAccount = emanager
				.createQuery("delete from Account account where account.group=:group and account.masterUser= :user")
				.setParameter("group", group).setParameter("user", user).executeUpdate();
		emanager.getTransaction().commit();
		emanager.close();

		logger.info("Account Deleted Succussfully on base of group Name, count = {} ", deletedAccount);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Account> updateAccountPassword( String url, String newpassword) {
		MasterUser user=CurrentAccount.getInstance().getCurrentUser();
		EntityManager emanager = entityManagerFactory.createEntityManager();
		emanager.getTransaction().begin();
		int updatedPassword = emanager.createQuery(
				"update Account account set account.password=:newpassword where account.url=:url and account.masterUser= :user")
				.setParameter("newpassword", newpassword).setParameter("url", url).setParameter("user", user)
				.executeUpdate();
		List<Account> list = emanager
				.createQuery("select account from Account account where account.password=:newpassword and account.masterUser= :user")
				.setParameter("newpassword", newpassword).setParameter("user", user).getResultList();
		emanager.getTransaction().commit();
		emanager.close();

		logger.info("Password updated Succussfully, count = {} ", updatedPassword);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Account> updateAccountUrl( String url, String newUrl) {
		MasterUser user=CurrentAccount.getInstance().getCurrentUser();
		EntityManager emanager = entityManagerFactory.createEntityManager();
		emanager.getTransaction().begin();
		int updatedUrl = emanager.createQuery(
				"update Account account set account.url=:newUrl where account.url=:url and account.masterUser= :user")
				.setParameter("newUrl", newUrl).setParameter("url", url).setParameter("user", user).executeUpdate();
		emanager.getTransaction().commit();

		List<Account> list = emanager.createQuery("select account from Account account where account.url=:newUrl and account.masterUser= :user")
				.setParameter("newUrl", newUrl).setParameter("user", user).getResultList();
		emanager.close();
		logger.info("Url updated Succussfully, count = {} ", updatedUrl);
		return list;
	}

	public boolean deleteAccountByUrl( String url) {
		MasterUser user=CurrentAccount.getInstance().getCurrentUser();
		EntityManager emanager = entityManagerFactory.createEntityManager();
		emanager.getTransaction().begin();
		int deletedUrl = emanager
				.createQuery("delete from Account account where account.url=:url and account.masterUser= :user")
				.setParameter("url", url).setParameter("user", user).executeUpdate();
		emanager.getTransaction().commit();
		emanager.close();
		logger.info("Account Deleted Succussfully on base of Url, count = {} ", deletedUrl);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Account> getDecryptedPassword( String url, String username) {
		MasterUser user=CurrentAccount.getInstance().getCurrentUser();
		List<Account> account = new ArrayList<>();
		EntityManager emanager = entityManagerFactory.createEntityManager();
		emanager.getTransaction().begin();
		account = emanager.createQuery(
				"select acc from Account acc  where acc.url=:url and acc.username=:username and acc.masterUser= :user")
				.setParameter("url", url).setParameter("username", username).setParameter("user", user).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return account;
	}

}
