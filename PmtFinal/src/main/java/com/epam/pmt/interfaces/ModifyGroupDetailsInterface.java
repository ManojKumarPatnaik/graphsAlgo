package com.epam.pmt.interfaces;

import java.util.List;

import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;

public interface ModifyGroupDetailsInterface {
	List<Account> modifyGroupDetails(AccountDataBase data, String groupName, String newGroup);

}
