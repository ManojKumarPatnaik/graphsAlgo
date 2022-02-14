package com.epam.pmt.servicelayer;

import java.util.List;

import com.epam.pmt.entity.Account;

public interface ModifyPasswordInterface {
	List<Account> modifyPassword( String url, String newPassword);

}
