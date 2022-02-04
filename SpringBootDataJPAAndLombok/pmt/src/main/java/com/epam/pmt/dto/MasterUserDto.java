package com.epam.pmt.dto;

import java.util.List;

import com.epam.pmt.entity.Account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



@Data
@EqualsAndHashCode
@ToString
public class MasterUserDto {


	private String username;
	private String password;

	private int userid;

	private List<Account> account;
	

}
