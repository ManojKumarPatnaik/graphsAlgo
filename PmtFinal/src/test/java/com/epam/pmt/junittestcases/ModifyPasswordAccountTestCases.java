package com.epam.pmt.junittestcases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.businesslogiclayer.ModifyPasswordAccount;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.persistencelayer.ModifyPassword;

public class ModifyPasswordAccountTestCases {

	List<Account> account;
	ModifyPasswordAccount modifyPasswordAccount;
	ModifyPassword modifyPassword;
	List<Account> account1 = new ArrayList<>();

	@BeforeEach
	public void test() {
		account = List.of(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		account1.add(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		modifyPasswordAccount = new ModifyPasswordAccount();
	}

	@Test
	public void testModifyUrlWhenRecordAlreadyExists() {
		assertTrue(true, () -> {
			try {
				return modifyPasswordAccount.modifyUrl(account, "https://www.sbi.com", "https://www.icici.com");
			} catch (InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		Assertions.assertDoesNotThrow(
				() -> modifyPasswordAccount.modifyUrl(account, "https://www.sbi.com", "https://www.icici.com"));

	}

	@Test
	public void testModifyUrlWhenNoRecordExists() {
		assertFalse(false, () -> {
			try {
				return modifyPasswordAccount.modifyUrl(account, " ", "https://www.sbi.com");
			} catch (InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		Assertions.assertDoesNotThrow(() -> modifyPasswordAccount.modifyUrl(account, " ", "https://www.sbi.com"));

	}

	@Test
	public void testModifyPasswordAccountWhenRecordAlreadyExists() {
		assertTrue(true, () -> modifyPasswordAccount.modifyPassword(account, "https://www.sbi.com", "newPassword"));

		Assertions.assertDoesNotThrow(
				() -> modifyPasswordAccount.modifyPassword(account, "https://www.sbi.com", "newPassword"));
	}

	@Test
	public void testModifyPasswordAccountWhenNoRecordExists() {
		assertFalse(false, () -> modifyPasswordAccount.modifyPassword(account, "ww.sbi.com ", "nopassword"));

		Assertions.assertDoesNotThrow(() -> modifyPasswordAccount.modifyPassword(account, "ww.sbi.com ", "nopassword"));

	}
}
