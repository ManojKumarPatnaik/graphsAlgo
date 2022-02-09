package com.epam.pmt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.epam.pmt.entity.MasterUser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class AccountDto {
	@NotBlank(message="URL can't be blank")
	@Pattern(regexp= "((http|https)://)(www.)?" + "[a-zA-Z0-9@:%_\\+~#?&=]" + "{2,256}\\.[a-z]"
			+ "{2,6}\\b([-a-zA-Z0-9@:%" + "_\\+~#?&=]*)" ,message="Invalid url")
	private String url;
	@NotBlank(message="UserName can't be blank")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z_$]{3,}$",message="Invalid UserName")
	private String username;
	@NotBlank(message="Password can't be empty")
	@Pattern(regexp= "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$" ,message="Invalid Password")
	private String password;
	@NotBlank(message="GroupName can't be blank")
	@Pattern(regexp="^[a-zA-Z][a-zA-Z_$]{3,}$",message="Invalid GroupName")
	private String group;
	private MasterUser masterUser;
	private int accountId;

	

}
