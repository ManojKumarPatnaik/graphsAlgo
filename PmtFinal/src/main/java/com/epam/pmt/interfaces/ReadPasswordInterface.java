package com.epam.pmt.interfaces;

import com.epam.pmt.databaselayer.AccountDataBase;

public interface ReadPasswordInterface {
	void getPassword(AccountDataBase data, String url, String accountUsername);

}
