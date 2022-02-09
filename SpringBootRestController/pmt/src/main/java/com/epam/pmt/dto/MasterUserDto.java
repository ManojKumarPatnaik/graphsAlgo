package com.epam.pmt.dto;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.epam.pmt.entity.Account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



@Data
@EqualsAndHashCode
@ToString
public class MasterUserDto {

	@NotBlank(message="Master UserName can't be blank")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z_$]{3,}$",message="Invalid UserName")
	private String username;
	@Pattern(regexp= "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$" ,message="Invalid Password")
	@Column(name = "Password")
	private String password;

	private int userid;

	private List<Account> account;
	

}
