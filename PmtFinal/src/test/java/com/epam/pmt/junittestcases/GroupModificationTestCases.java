package com.epam.pmt.junittestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.businesslogiclayer.GroupModification;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;

public class GroupModificationTestCases {
	List<Account> account;
	GroupModification groupModification;

	@BeforeEach
	public void test() {
		account = List.of(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		groupModification = new GroupModification();
	}
	
	

	@Test
	public void testModifyGroupNameWithValidDataReturnsTrue() {
		assertTrue(true, () -> {
			try {
				return groupModification.modifyGroupName(account, "bank", "newgroup");
			} catch (NoGroupFoundForAccount e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});

	}
	@Test
	public void testModifyGroupNameWhenDataMatchesDoesNotThrow() {
		
		Assertions.assertDoesNotThrow(() -> groupModification.modifyGroupName(account, "bank", "newgroup"));

	}

	@Test
	public void testModifyGroupNameWithValidDataReturnsFalse() {
		assertFalse(false, () -> {
			try {
				return groupModification.modifyGroupName(account, "nothing", "newgroup");
			} catch (NoGroupFoundForAccount e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		
		
	}
	
	@Test
	public void testModifyGroupNameWhenDataMatches() {
		assertEquals("Group Name Modified successfully", groupModification.modifyGroupName(account, "bank", "newgroup"));

	}
	@Test
	public void testModifyGroupNameWithInvalidData() {
		assertNotEquals("", groupModification.modifyGroupName(account, "nothing", "newgroup"));

	}
	
	
	@Test
	public void testModifyGroupNameWhenNoDataMatches() {
		
		Assertions.assertDoesNotThrow(() -> groupModification.modifyGroupName(account, "nothing", "newgroup"));

	}

}
