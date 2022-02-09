package com.epam.pmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Account_Table")
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


	public Account(int accountId, String url, String username, String password, String group) {
		super();
		this.accountId = accountId;
		this.url = url;
		this.username = username;
		this.password = password;
		this.group = group;
	}




	
	

}
