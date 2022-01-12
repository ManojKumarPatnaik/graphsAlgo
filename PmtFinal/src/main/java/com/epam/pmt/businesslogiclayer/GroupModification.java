package com.epam.pmt.businesslogiclayer;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;

public class GroupModification {
	public String modifyGroupName(List<Account> filterAccountDetails, String groupName, String newGroupName) throws NoGroupFoundForAccount {
		filterAccountDetails.stream().filter(account -> account.getGroup().equals(groupName))
				.peek(account -> account.setGroup(newGroupName)).collect(Collectors.toList());
		return "Group Name Modified successfully";
	}


}
