package com.epam.pmt.interfaces;

import java.util.List;

import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;

public interface ModifyUrlInterface {
	List<Account> modifyUrl(AccountDataBase data, String url, String newUrl);

}
