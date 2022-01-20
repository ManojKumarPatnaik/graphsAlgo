package com.epam.pmt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MasterUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MasterUser(int userid, List<Account> account, String username, String password) {
		super();
		this.userid = userid;
		this.account = account;
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


//@TableGenerator(name="TABLE_Master",table="T_GENERATOR",pkColumnName="GEN_KEY",pkColumnValue="TEST",valueColumnName="GEN_VALUE",initialValue=1,allocationSize=1)
//@GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_Master")
//@JoinTable(name = "MASTER_ACCOUNT_ID")