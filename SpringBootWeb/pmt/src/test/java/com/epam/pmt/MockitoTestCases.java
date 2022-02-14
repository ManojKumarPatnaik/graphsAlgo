
package com.epam.pmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.pmt.database.CrudOperationsDb;
import com.epam.pmt.database.CrudOperationsDbImpl;
import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.LoginFirstException;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;
import com.epam.pmt.presentationlayer.CurrentAccount;
import com.epam.pmt.servicelayer.CrudOperationsServiceImpl;
import com.epam.pmt.validation.AccountValidation;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;

@ExtendWith(MockitoExtension.class)
class MockTest {
	@InjectMocks
	CrudOperationsServiceImpl crudOperationsServiceImpl;
	@Mock
	CrudOperationsDbImpl crudOperationsDbImpl;
	@Mock
	Account account;
	@Mock
	EncryptDecryptPassword encryptdecrypt;
	@Mock
	ValidationPassword validationPassword;
	List<Account> list = new ArrayList<>();
	@Mock
	EncryptionAndDecryption encryptDecrypt;
	@Mock
	MasterUser masterUser;
	@Mock
	CurrentAccount current;
	@Mock
	ValidateUserName validateUserName;
	@Mock
	AccountValidation accountValidation;
	
	@BeforeEach
	void setUp() {
		masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
//		account=new Account("https://www.sbi.com", "manoj", "Manoj123", "bank");
		list.add(new Account("https://www.sbi.com", "manoj", "Manoj123", "bank"));
		list.add(new Account("https://www.icici.com", "ajeet", "Ajeet@123", "ajeetBank"));
		list.add(new Account("https://www.Boi.com", "kumar", "Kumar12", "dummy"));
		
	}

	

	
	

	/* Read Account List Test Case */

//	@Test
//	 void testAccountList() {
//
//		List<Account> list = new ArrayList<Account>();
//		list.add(new Account("https://www.sbi.com", "kujmar", "Manoj1", "bank"));
//		Mockito.when(crudOperationsDbImpl.getAccountList()).thenReturn(list);
//		Assertions.assertEquals(list, crudOperationsServiceImpl.viewAllAccounts());
//	}

	/* Read Master User Details */

//	@Test
//	void testDisplayMasterUsers() {
//
//		List<MasterUser> masterList = new ArrayList<MasterUser>();
//		masterList.add(new MasterUser("manoj", "Manoj1"));
//		when(crudOperationsDbImpl.getAllUsers()).thenReturn(masterList);
//		Assertions.assertEquals(masterList, crudOperationsServiceImpl.viewAllUsers());
//	}

//	/* Display Account List by Group Name */
//
//	@Test
//	 void testDisplayAccountDetailsByGroupName() {
//		lenient().when(crudOperationsDbImpl.getAccountList()).thenReturn(list);
//		when(crudOperationsDbImpl.listAccountByGroupName("bank")).thenReturn(list);
//		Assertions.assertEquals(list, crudOperationsServiceImpl.getAccountByGroupName("bank"));
//	}
//
//	@Test
//	 void testDisplayAccountDetailsByGroupNameWithNull() {
//		when(crudOperationsDbImpl.listAccountByGroupName(null)).thenReturn(list);
//		Assertions.assertEquals(list, crudOperationsServiceImpl.getAccountByGroupName(null));
//	}
//	
//	@Test
//	 void testDisplayAccountDetailsByGroupNameWithInCorrectDetails() {
//		when(crudOperationsDbImpl.listAccountByGroupName("nothing")).thenReturn(list);
//		Assertions.assertEquals(list, crudOperationsServiceImpl.getAccountByGroupName("nothing"));
//	}
//
//	/* Delete Group Name Test Cases */
//
//	@Test
//	 void testDeleteAccountByGroup_With_Correct_Details() {
//		when(crudOperationsDbImpl.getAccountList()).thenReturn(list);
//		when(crudOperationsDbImpl.deleteAccountByGroupName("bank")).thenReturn(true);
//		Assertions.assertEquals(true, crudOperationsServiceImpl.deleteAccountByGroup("bank"));
//
//	}
//	@Test
//	 void testDeleteAccountByGroup_With_Null_Details() {
//		when(crudOperationsDbImpl.deleteAccountByGroupName(null)).thenReturn(false);
//		Assertions.assertFalse(crudOperationsDbImpl.deleteAccountByGroupName(null));
//
//	}
	
//	@Test
//	void testAddAccount() {
//		try {
//		when(CurrentAccount.getInstance().getCurrentUser()).thenReturn(masterUser);
//		when(crudOperationsDbImpl.add(account)).thenReturn(true);
//		when(crudOperationsServiceImpl.addAccount(account)).thenThrow(LoginFirstException.class);
//		}catch(Exception message) {
//		Assertions.assertFalse(message instanceof LoginFirstException);
//		
//		}
//	}
	
	
//	@Test
//	void testAddAccountThenReturnTrue() {
//		when(crudOperationsDbImpl.add(account)).thenReturn(true);
//		Assertions.assertTrue(crudOperationsServiceImpl.addAccount(account));
//		
//	}
	
//	@Test
//	void getAccountByIdTest() {
//		account.setAccountId(1);
//		account=new Account("https://www.sbi.com", "manoj", "Manoj123", "bank");
//		when(crudOperationsDbImpl.getAccountById(account.getAccountId())).thenReturn(account);
//		Assertions.assertEquals(account,crudOperationsServiceImpl.getAccountById(account.getAccountId()));
//		
//	}
	

	
	
	
	
//	@Test
//	 void testDeleteAccountByGroup_With_InCorrect_Details() {
//		try {
//		lenient().when(crudOperationsDbImpl.getAccountList()).thenReturn(list);
//		lenient().when(crudOperationsDbImpl.deleteAccountByGroupName(anyString())).thenReturn(false);
//		when(crudOperationsServiceImpl.deleteAccountByGroup(anyString())).thenThrow(NoRecordFoundForGroup.class);
//		}catch(Exception message) {
//		Assertions.assertFalse(message instanceof NoRecordFoundForGroup );
//		}
//	}
//
	
//
//	/* Delete URL Test Cases */
//
//	@Test
//	 void testDeleteAccountByUrl_With_Correct_Details() {
//		when(crudOperationsDbImpl.getAccountList()).thenReturn(list);
//		when(crudOperationsDbImpl.deleteAccountByUrl("https://www.sbi.com")).thenReturn(true);
//		Assertions.assertEquals(true, crudOperationsServiceImpl.deleteAccountByUrl("https://www.sbi.com"));
//	}
//
//	
//
//	
//
//	@Test
//	void testReadPassword_With_Correct_Details() throws AccountDoesNotExistException, InvalidUrlException {
//		when(crudOperationsDbImpl.getDecryptedPasswordList( "manoj")).thenReturn(list); 
//		when(encryptDecrypt.getDecryptedPassword(list,  "manoj")).thenReturn("Manoj@123"); 
//		Assertions.assertEquals("Manoj@123", crudOperationsServiceImpl.getPassword( "manoj"));
//	}
//  
//  
	
//	@Test
//	void testGetPassword() {
//		List<Account> list=crudOperationsDbImpl.getDecryptedPasswordList("manoj");
//		when(encryptDecrypt.getDecryptedPassword(list,"manoj")).thenReturn("Manoj@123");
//		when(crudOperationsDbImpl.getDecryptedPasswordList("manoj")).thenReturn(list);
//		assertEquals("Manoj@123", crudOperationsServiceImpl.getPassword("manoj"));
//	}
//  

//	@Test
//	void testDeleteAccountByUrl_With_InCorrect_Details() {
//		try {
//			when(crudOperationsServiceImpl.deleteAccountByUrl(anyString())).thenThrow(InvalidUrlException.class);
//		} catch (Exception message) {
//			Assertions.assertFalse(message instanceof InvalidUrlException);
//
//		}
//	}
//  
//  
//	@Test
//	void testDeleteAccountByUrl_With_Null_Details() {
//		try {
//			when(crudOperationsServiceImpl.deleteAccountByUrl(null)).thenThrow(InvalidUrlException.class);
//		} catch (Exception message) {
//			Assertions.assertTrue(message instanceof InvalidUrlException);
//
//		}
//	}
	
//	@Test
//	void updateAccountTest() {//2 voids
//		account.setAccountId(1);
//		account=new Account("https://www.sbi.com", "manoj", "Manoj123", "bank");
//		doNothing().when(crudOperationsDbImpl).updateAccountDetails(1,"https://www.sbi.com", "manoj", "Manoj123", "bank");
//		doNothing().when(crudOperationsServiceImpl).updateAccount(account);
//	}
	
	
	
// /* Decoding Password Test Cases*/
//
//	@Test
//	 void testPasswordIsDecryptedReturnTrue() {
//		String password = "CKX5k3qZMv94/mthvcZIpw==";
//		when(encryptdecrypt.decrypt(password)).thenReturn("Manoj@123");
//		assertEquals("Manoj@123", encryptdecrypt.decrypt(password));
//	}
//
//	@Test
//
//	 void testPasswordIsDecrypted() {
//		String password = "CKX5k3qZMv94/mthvcZIpw==";
//		Assertions.assertNotEquals("", encryptdecrypt.decrypt(password));
//	}
//
//	@Test
//	 void testEmptyPasswordIsDecryptedReturnTrue() {
//		String password = "07RI3s/vhYkKf2GvA1kY/w==";
//		when(encryptdecrypt.decrypt(password)).thenReturn("");
//		assertEquals("", encryptdecrypt.decrypt(password));
//	}
//
//	@Test
//	 void testEmptyPasswordIsDecrypted() {
//		String password = "07RI3s/vhYkKf2GvA1kY/w==";
//		Assertions.assertNotEquals("Manoj", encryptdecrypt.decrypt(password));
//	}

//	/* Encoding Password Test Cases */
//
//	@Test
//	void testPasswordIsEncryptedReturnTrue() {
//		String password = "Manoj@123";
//		when(encryptdecrypt.decrypt(password)).thenReturn("CKX5k3qZMv94/mthvcZIpw==");
//		assertEquals("CKX5k3qZMv94/mthvcZIpw==", encryptdecrypt.decrypt(password));
//	}
//
//	@Test
//	void testEmptyPasswordIsEncryptedReturnTrue() {
//		String password = "";
//		when(encryptdecrypt.decrypt(password)).thenReturn("07RI3s/vhYkKf2GvA1kY/w==");
//		assertEquals("07RI3s/vhYkKf2GvA1kY/w==", encryptdecrypt.decrypt(password));
//	}
//
//	@Test
//	void testNullPasswordIsEncrypted() {
//		String password = null;
//		Assertions.assertNull(null, encryptdecrypt.decrypt(password));
//	}
//
//	/* Validation Of URL and Password TestCases */
//
//	@Test
//	 void ifInCorrectPasswordAndUrlReturnFalse() {
//		String password = "manoj";
//		String url = "ww.demo";
//		when(validationPassword.validPassword(password)).thenReturn(false);
//		assertFalse(validationPassword.validPassword(password));
//		when(accountValidation.isValidURL(url)).thenReturn(false);
//		assertFalse(accountValidation.isValidURL(url));
//	}
//
//	@Test
//	 void ifCorrectPasswordAndUrlReturnTrue() {
//		String inputPassword = "Manoj@123";
//		String url = "https://www.geeksforgeeks.org";
//		when(validationPassword.validPassword(inputPassword)).thenReturn(true);
//		assertTrue(validationPassword.validPassword(inputPassword));
//		when(accountValidation.isValidURL(url)).thenReturn(true);
//		assertTrue(accountValidation.isValidURL(url));
//	}
//
//	@Test
//	 void ifInCorrectPasswordAndCorrectUrl() {
//		String password = "manoj";
//		String url = "https://www.geeksforgeeks.org";
//		when(validationPassword.validPassword(password)).thenReturn(false);
//		assertFalse(validationPassword.validPassword(password));
//		when(accountValidation.isValidURL(url)).thenReturn(true);
//		assertTrue(accountValidation.isValidURL(url));
//	}

//	@Test
//	 void ifCorrectPasswordAndInCorrectUrl() {
//		String password = "Demo@1234";
//		String url = "www.geeksforgeeks.org";
//		when(validationPassword.validPassword(password)).thenReturn(true);
//		assertTrue(validationPassword.validPassword(password));
//		when(accountValidation.isValidURL(url)).thenReturn(false);
//		assertFalse(accountValidation.isValidURL(url));
//	}
//
//	@Test
//	 void ifNullUrl() {
//		String password = "Demo@1234";
//		String url = null;
//		when(validationPassword.validPassword(password)).thenReturn(true);
//
//		assertTrue(validationPassword.validPassword(password));
//		when(accountValidation.isValidURL(url)).thenReturn(false);
//
//		assertFalse(accountValidation.isValidURL(url));
//	}
//
//	@Test
//	 void ifNullPassword() {
//		String password = "";
//		String url = "";
//		when(validationPassword.validPassword(password)).thenReturn(false);
//
//		assertFalse(validationPassword.validPassword(password));
//		when(accountValidation.isValidURL(url)).thenReturn(false);
//
//		assertFalse(accountValidation.isValidURL(url));
//	}
//
//	@Test
//	 void ifPasswordReturnsTrue() {
//		String password = "Manoj@1";
//		String url = "";
//		when(validationPassword.validPassword(password)).thenReturn(true);
//
//		Assertions.assertEquals(true, validationPassword.validPassword(password));
//		when(accountValidation.isValidURL(url)).thenReturn(false);
//
//		assertFalse(accountValidation.isValidURL(url));
//	}

}
