package com.epam.pmt.businesslogiclayer;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;

public class DisplayAccountDetailsByGroup {
	public List<Account> getListByGroup(List<Account> filterAccountDetails, String groupBy)
			throws NoGroupFoundForAccount {
		return filterAccountDetails.stream().filter(account -> account.getGroup().equals(groupBy))
				.collect(Collectors.toList());
	}

}
