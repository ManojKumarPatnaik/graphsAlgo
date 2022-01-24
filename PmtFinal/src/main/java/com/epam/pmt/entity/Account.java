package com.epam.pmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.mainapp.Main;

@Entity
@Table(name = "Account_Table")
@Component
@Scope(value="prototype")
public class Account {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	@Column(name="domainUrl")
	private String url;
	@Column(name="domainusername")
	private String username;
	@Column(name="domainpassword")
	private String password;
	@Column(name="groupname")
	private String group;
	@ManyToOne(targetEntity = MasterUser.class)
	private MasterUser masterUser;
	
	public Account(String url, String username, String password, String group) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.group = group;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




	public MasterUser getMasterUser() {
		return masterUser;
	}

	public void setMasterUser(MasterUser masterUser) {
		this.masterUser = masterUser;
	}

	public Account() {
	super();
	}

	
	public int getAccountId() {
	return accountId;
	}



	public void setAccountId(int accountId) {
	this.accountId = accountId;
	}


	public String getGroup() {
	return group;
	}



	public void setGroup(String group) {
	this.group = group;
	}

	@Override
	public String toString() {
		return "Account [url=" + url + ", userName=" + username + ", password=" + password + ", group=" + group + "]";
	}

	@SuppressWarnings("resource")
	public String getDecryptedPassword() {
		ApplicationContext context=new AnnotationConfigApplicationContext(Main.class);
		return context.getBean(EncryptDecryptPassword.class).Decrypt(this.password);
	}
	
	

}
