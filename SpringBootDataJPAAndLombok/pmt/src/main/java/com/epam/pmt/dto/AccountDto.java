package com.epam.pmt.dto;

import com.epam.pmt.entity.MasterUser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class AccountDto {

	private String url;

	private String username;
	private String password;
	private String group;
	private MasterUser masterUser;
	private int accountId;

	

}
