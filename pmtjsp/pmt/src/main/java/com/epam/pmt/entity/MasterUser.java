package com.epam.pmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Master_User_Details")
public class MasterUser {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int userid;

	@OneToMany(mappedBy = "masterUser",fetch = FetchType.LAZY)
	private List<Account> account;


	@Column(name = "User_Name")
	private String username;
	@Column(name = "Password")
	private String password;

	public List<Account> getAccount() {
		return account;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

	public String getUsername() {
		return username;
	}

	public void setAccount(List<Account> account) {
		
		this.account = account;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public MasterUser() {
		super();
	}
	public MasterUser(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "MasterUser [userid=" + userid +  ", username=" + username + ", password="
				+ password + "]";
	}

	public MasterUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}


