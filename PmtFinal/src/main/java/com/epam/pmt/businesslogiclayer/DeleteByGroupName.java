package com.epam.pmt.businesslogiclayer;

import java.util.ArrayList;
import java.util.List;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;

public class DeleteByGroupName {
	public String deleteAccount(List<Account> filterAccountDetails, String group) throws NoRecordFoundForGroup{
		filterAccountDetails.stream().filter(account -> account.getGroup().equals(group)).findFirst().get();

		List<Account> newList = new ArrayList<>();
		filterAccountDetails.stream().filter(account -> account.getGroup().equals(group)).forEach(newList::add);

		filterAccountDetails.removeAll(newList);
		return "Account Deleted successfully";
	}

	
}
