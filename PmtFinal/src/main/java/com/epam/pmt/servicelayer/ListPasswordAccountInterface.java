package com.epam.pmt.servicelayer;

import java.util.List;

import com.epam.pmt.entity.Account;

public interface ListPasswordAccountInterface {
	List<Account> getAccountByGroupName( String groupName);

}
