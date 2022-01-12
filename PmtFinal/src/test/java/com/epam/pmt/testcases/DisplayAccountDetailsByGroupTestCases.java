package com.epam.pmt.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.businesslogiclayer.DisplayAccountDetailsByGroup;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;

public class DisplayAccountDetailsByGroupTestCases {
	List<Account> account = new ArrayList<>();
	List<Account> account1;
	DisplayAccountDetailsByGroup displayAccountDetailsByGroup;

	@BeforeEach
	public void test() {
		account.add(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		account1 = List.of(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		displayAccountDetailsByGroup = new DisplayAccountDetailsByGroup();

	}

	@Test
	public void testGetListByGroupNameWhenRecordsMatches() {
		assertEquals(account, displayAccountDetailsByGroup.getListByGroup((ArrayList<Account>) account, "bank"));
	}

	@Test
	public void testGetListByGroupNameWhenNoRecordsMatches() {
		Assertions.assertNotSame(account,
				displayAccountDetailsByGroup.getListByGroup((ArrayList<Account>) account, ""));
	}

	@Test
	public void testGetListByGroupThrowsExceptionWhenRecordAlreadyExists() throws NoGroupFoundForAccount {

		Assertions.assertThrows(ClassCastException.class,
				() -> displayAccountDetailsByGroup.getListByGroup((ArrayList<Account>) account1, "bank"));
	}

	@Test
	public void testGetListByGroupNameWhenNoRecordsMatchesReturnsFalse() {
		Assertions.assertNotEquals(false,
				displayAccountDetailsByGroup.getListByGroup((ArrayList<Account>) account, " "));
	}

	@Test
	public void testGetListByGroupThrowsExceptionWhenNoRecordExists() {

		Assertions.assertThrows(ClassCastException.class,
				() -> displayAccountDetailsByGroup.getListByGroup((ArrayList<Account>) account1, ""));
	}

	@Test
	public void testGetListByGroupNameWhenRecordsMatchesReturnsTrue() {
		Assertions.assertNotEquals(true,
				displayAccountDetailsByGroup.getListByGroup((ArrayList<Account>) account, "bank"));
	}

}
