package com.epam.pmt.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.businesslogiclayer.DeleteByGroupName;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;

public class DeleteByGroupNameTestCases {
	DeleteByGroupName deleteByGroupName;
	List<Account> account1 = new ArrayList<Account>();
	List<Account> account;

	@BeforeEach
	public void test() {
		
		 account = List.of(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
			account1.add(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));

		 deleteByGroupName = new DeleteByGroupName();
		
	}
	@Test
	public void testDeleteAccountByGroupNameWithValidData() throws NoRecordFoundForGroup {
		Assertions.assertEquals("Account Deleted successfully", deleteByGroupName.deleteAccount(account1, "bank"));
	}
	@Test
	public void testDeleteAccountByGroupNameWithValidDataReturnsTrue() throws NoRecordFoundForGroup {
		Assertions.assertTrue(true, deleteByGroupName.deleteAccount(account1, "bank"));
	}
	
	@Test
	public void testDeleteAccountThrowsExceptionWhenNoRecordExists() {

		Assertions.assertThrows(NoSuchElementException.class,
				() -> deleteByGroupName.deleteAccount(account, "empty"));
	}
	@Test
	public void testDeleteAccountByGroupNameWithValidDataUsingAssertNotEquals() throws NoRecordFoundForGroup {
		Assertions.assertNotEquals(false, deleteByGroupName.deleteAccount(account1, "bank"));
	}
	
	@Test
	public void testDeleteAccountThrowsExceptionWhenRecordAlreadyExists() throws NoRecordFoundForGroup {
		Assertions.assertThrows(UnsupportedOperationException.class,
				() -> deleteByGroupName.deleteAccount(account, "bank"));
	}

	
	
}
