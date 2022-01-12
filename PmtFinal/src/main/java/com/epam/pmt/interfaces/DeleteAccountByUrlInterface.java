package com.epam.pmt.interfaces;

import com.epam.pmt.databaselayer.AccountDataBase;

public interface DeleteAccountByUrlInterface {
	void deleteAccountByUrl(AccountDataBase data, String url);

}
