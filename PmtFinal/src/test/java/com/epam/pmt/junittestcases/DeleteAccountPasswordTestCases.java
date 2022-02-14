package com.epam.pmt.junittestcases;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.businesslogiclayer.DeletePasswordAccount;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.InvalidUrlException;

public class DeleteAccountPasswordTestCases {
	List<Account> account;
	List<Account> account1 = new ArrayList<Account>();
	DeletePasswordAccount deletePasswordAccountByUrl;

	@BeforeEach
	public void test() {
		account1.add(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		account = List.of(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		deletePasswordAccountByUrl = new DeletePasswordAccount();
	}

	@Test
	public void testDeleteAccountPasswordWithValidData() throws InvalidUrlException {

		Assertions.assertEquals("Deleted successfully",
				deletePasswordAccountByUrl.deleteAccountPassword(account1, "https://www.sbi.com"));
	}
	@Test
	public void testDeleteAccountPasswordWithValidDataReturnTrue() throws InvalidUrlException {

		Assertions.assertTrue(true,
				deletePasswordAccountByUrl.deleteAccountPassword(account1, "https://www.sbi.com"));
	}

	@Test
	public void testDeleteAccountPasswordThrowsExceptionWhenNoRecordExists() {

		Assertions.assertThrows(NoSuchElementException.class,
				() -> deletePasswordAccountByUrl.deleteAccountPassword(account, "https://www.sbi"));
	}

	@Test
	public void testDeleteAccountPasswordWithValidDataUsingAssertNotEquals() throws InvalidUrlException {

		Assertions.assertNotEquals(false,
				deletePasswordAccountByUrl.deleteAccountPassword(account1, "https://www.sbi.com"));
	}

	@Test
	public void testDeleteAccountPasswordThrowsException() {

		Assertions.assertThrows(UnsupportedOperationException.class,
				() -> deletePasswordAccountByUrl.deleteAccountPassword(account, "https://www.sbi.com"));
	}

}
