package com.epam.pmt.interfaces;

import com.epam.pmt.databaselayer.AccountDataBase;

public interface DeleteAccountInterface {
	void deleteAccountByGroup(AccountDataBase data, String groupName);

}
