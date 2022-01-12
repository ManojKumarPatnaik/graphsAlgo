package com.epam.pmt.interfaces;

import com.epam.pmt.databaselayer.AccountDataBase;

public interface ListPasswordAccountInterface {
	void getAccountByGroupName(AccountDataBase data, String groupName);

}
