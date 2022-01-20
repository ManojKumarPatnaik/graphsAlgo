package com.epam.pmt.persistencelayer;

import java.util.List;

import com.epam.pmt.entity.Account;

public interface ListPasswordAccountInterface {
	List<Account> getAccountByGroupName( String groupName);

}
