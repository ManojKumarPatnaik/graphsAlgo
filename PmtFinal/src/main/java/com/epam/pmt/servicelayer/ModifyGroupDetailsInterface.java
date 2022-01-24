package com.epam.pmt.servicelayer;

import java.util.List;

import com.epam.pmt.entity.Account;

public interface ModifyGroupDetailsInterface {
	List<Account> modifyGroupDetails( String groupName, String newGroup);

}
