package com.epam.pmt.servicelayer;

import java.util.List;

import com.epam.pmt.entity.Account;

public interface ModifyUrlInterface {
	List<Account> modifyUrl(String url, String newUrl);

}
