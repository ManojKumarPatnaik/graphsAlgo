
package com.epam.pmt.businesslogiclayer;

import java.util.ArrayList;
import java.util.List;

import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;

public class DeletePasswordAccount {
	public String deleteAccountPassword(List<Account> filterAccountDetails, String url) throws InvalidUrlException {
		filterAccountDetails.stream().filter(account -> account.getUrl().equals(url)).findFirst().get();

		List<Account> newList = new ArrayList<>();
		filterAccountDetails.stream().filter(account -> account.getUrl().equals(url)).forEach(newList::add);
		filterAccountDetails.removeAll(newList);
		return "Deleted successfully";
	}
}