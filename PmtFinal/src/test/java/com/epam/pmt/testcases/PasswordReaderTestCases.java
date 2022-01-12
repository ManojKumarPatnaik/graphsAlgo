package com.epam.pmt.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.pmt.businesslogiclayer.PasswordReader;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;

public class PasswordReaderTestCases {
	List<Account> account;
	List<Account> account1=new ArrayList<>();
	PasswordReader passwordReader;

		
	@BeforeEach
	public void test() {
		account = List.of(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		account1.add(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
		passwordReader = new PasswordReader();

	}
	@Test
	public void testGetPasswordWithValidData() throws AccountDoesNotExistException, InvalidUrlException {
		assertEquals("",passwordReader.getPassword((ArrayList<Account>) account1, "https://www.sbi.com", "manoj"));
	}
	@Test
	public void testGetPasswordWithInValidData() throws AccountDoesNotExistException, InvalidUrlException {
		assertNotEquals(false,passwordReader.getPassword((ArrayList<Account>) account1, "https://www.sbi", "manoj"));
	}
	@Test
	public void testGetPasswordWithValidDataReturnsTrue() throws AccountDoesNotExistException, InvalidUrlException {
		assertTrue(true,passwordReader.getPassword((ArrayList<Account>) account1, "https://www.sbi.com", "manoj"));
	}
	@Test
	public void testGetPasswordWithValidDataReturnsFalse() throws AccountDoesNotExistException, InvalidUrlException {
		assertFalse(false,passwordReader.getPassword((ArrayList<Account>) account1, "https://www.sbi", "manoj"));
	}

	@Test
	public void testGetPasswordThrowsExceptionWhenRecordAlreadyExists() {
		Assertions.assertTrue(true, () -> {
			try {
				return passwordReader.getPassword((ArrayList<Account>) account, "https://www.sbi.com", "manoj");
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		
		Assertions.assertFalse(false, () -> {
			try {
				return passwordReader.getPassword((ArrayList<Account>) account, "https://www.sbi.com", "manoj");
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});

		Assertions.assertThrows(ClassCastException.class,
				() -> passwordReader.getPassword((ArrayList<Account>) account, "https://www.sbi.com", "manoj"));
	}

	@Test
	public void testGetPasswordThrowsExceptionWhenNoRecordExists() {
		Assertions.assertThrows(ClassCastException.class,
				() -> passwordReader.getPassword((ArrayList<Account>) account, " ", " "));
		Assertions.assertTrue(true, () -> {
			try {
				return passwordReader.getPassword((ArrayList<Account>) account, " ", " ");
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});

		Assertions.assertFalse(false, () -> {
			try {
				return passwordReader.getPassword((ArrayList<Account>) account, " ", " ");
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});

	}

	@Test
	public void testGetDecryptedPasswordWithValidData() throws AccountDoesNotExistException, InvalidUrlException {
		assertEquals("Manoj1",passwordReader.getDecryptedPassword((ArrayList<Account>) account1, "https://www.sbi.com",
				"manoj"));
		
	}
	@Test
	public void testGetDecryptedPasswordWithInValidData() throws AccountDoesNotExistException, InvalidUrlException {
		assertThrows(IndexOutOfBoundsException.class,()->passwordReader.getDecryptedPassword((ArrayList<Account>) account1, "https://www.sbi",
				"manoj"));
		
	}
	@Test
	public void testGetDecryptedPasswordWithValidDataReturnsTrue() throws AccountDoesNotExistException, InvalidUrlException {
		assertTrue(true,passwordReader.getDecryptedPassword((ArrayList<Account>) account1, "https://www.sbi.com",
				"manoj"));
		
	}
	
	@Test
	public void testGetDecryptedPasswordThrowsException()
			throws AccountDoesNotExistException, InvalidUrlException {
		Assertions.assertTrue(true, () -> {
			try {
				return passwordReader.getDecryptedPassword((ArrayList<Account>) account, "https://www.sbi.com",
						"manoj");
			} catch (AccountDoesNotExistException | InvalidUrlException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		});

		Assertions.assertFalse(false, () -> {
			try {
				return passwordReader.getDecryptedPassword((ArrayList<Account>) account, "https://www.sbi.com",
						"manoj");
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});

		Assertions.assertThrows(ClassCastException.class, () -> passwordReader
				.getDecryptedPassword((ArrayList<Account>) account, "https://www.sbi.com", "manoj"));
	}

	@Test
	public void testGetDecryptedPasswordThrowsExceptionWhenNoRecordExists() {
		Assertions.assertThrows(ClassCastException.class,
				() -> passwordReader.getDecryptedPassword((ArrayList<Account>) account, " ", " "));
		Assertions.assertTrue(true, () -> {
			try {
				return passwordReader.getDecryptedPassword((ArrayList<Account>) account, " ", " ");
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});

		Assertions.assertFalse(false, () -> {
			try {
				return passwordReader.getDecryptedPassword((ArrayList<Account>) account, " ", " ");
			} catch (AccountDoesNotExistException | InvalidUrlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});

	}
	
	

}
