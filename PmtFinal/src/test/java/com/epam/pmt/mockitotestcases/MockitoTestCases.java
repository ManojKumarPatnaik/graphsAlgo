package com.epam.pmt.mockitotestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.persistencemanager.CrudOperations;
import com.epam.pmt.servicelayer.CreateAccountDetails;
import com.epam.pmt.servicelayer.DeleteAccountByGroupName;
import com.epam.pmt.servicelayer.ListPasswordAccountAndGroup;
import com.epam.pmt.servicelayer.ModifyGroupDetails;
import com.epam.pmt.servicelayer.ModifyPassword;
import com.epam.pmt.servicelayer.ModifyUrl;
import com.epam.pmt.servicelayer.ReadPassword;
import com.epam.pmt.validation.ValidationPassword;
import com.epam.pmt.validation.ValidationUrl;


@ExtendWith(MockitoExtension.class)
public class MockitoTestCases {
	
	
	@Mock
	CrudOperations crud;
	
	@Mock
	CreateAccountDetails createAccountDetails;
	
	@Mock
	Account account;
	
	@Mock
	EncryptDecryptPassword encryptdecrypt;
	
	
	@Mock
	ValidationPassword validationPassword;
	
	@Mock
	ValidationUrl validationUrl;
	@InjectMocks
	ListPasswordAccountAndGroup viewByGroup;
	List<Account> list=new ArrayList<>();
	@InjectMocks
	DeleteAccountByGroupName deleteGroup;
	@InjectMocks
	ModifyGroupDetails modifyGroup;
	@InjectMocks
	ModifyUrl modifyUrl;
	@Mock
	EncryptionAndDecryption encryptDecrypt;
	@InjectMocks
	ModifyPassword modifyPassword;
	@InjectMocks
	ReadPassword readPassword;
	
	@BeforeEach
	void setUp() {
		
		account.setUsername("manoj");
		account.setGroup("bank");
		account.setPassword("Manoj123");
		account.setUrl("https://www.sbi.com");
		list.add(new Account("https://www.sbi.com","manoj","Manoj123","bank"));
		list.add(new Account("https://www.icici.com","ajeet","Ajeet@123","ajeetBank"));
		list.add(new Account("https://www.Boi.com","kumar","Kumar12","dummy"));
	}
	
	
	/* create Account Test Cases */
	
	
	@Test
	void testCreateAccount() {
		
		
		when(createAccountDetails.add(account)).thenReturn(true);
		
		Assertions.assertTrue(createAccountDetails.add(account));

		
	}
	
	
	
	
	/* Update Group Name Test Cases */
	
	@Test
	public void testUpdateAccountByGroupName_With_Correct_Details() {
		when(crud.getAccountList()).thenReturn(list);
		when(crud.updateAccountByGroupName("bank","UpdatedGroup")).thenReturn(list);
		Assertions.assertEquals(list,modifyGroup.modifyGroupDetails("bank","UpdatedGroup"));
	}
	
	
	@Test
	public void testUpdateAccountByGroupName_With_InCorrect_Details() {
		when(crud.getAccountList()).thenReturn(list);
		lenient().when(crud.updateAccountByGroupName("123","UpdatedGroup")).thenReturn(list);
		List<Account> expected=list.stream().filter(account->account.getGroup().equals("123")).collect(Collectors.toList());
		Assertions.assertEquals(expected,modifyGroup.modifyGroupDetails("123","UpdatedGroup"));
	}
	
	
	@Test
	public void testUpdateAccountByGroupName_With_Null_Values() {
		when(crud.getAccountList()).thenReturn(list);
		lenient().when(crud.updateAccountByGroupName(null,null)).thenReturn(list);
		List<Account> expected=list.stream().filter(account->account.getGroup().equals(null)).collect(Collectors.toList());
		Assertions.assertEquals(expected,modifyGroup.modifyGroupDetails(null,null));
	}
	
	
	/* Read Account List  Test Case*/
	
	@Test
	public void testAccountList() {
		
		List<Account> list=new ArrayList<Account>();
		list.add(new Account("https://www.sbi.com", "kujmar", "Manoj1", "bank"));
		Mockito.when(crud.getAccountList()).thenReturn(list);
		Assertions.assertEquals(list,crud.getAccountList());
	}
	
	/* Read Master User Details */
	
	@Test
	void testDisplayMasterUsers()  {

		List<MasterUser> masterList=new ArrayList<MasterUser>();
		masterList.add(new MasterUser("manoj","Manoj1"));
		when(crud.getAllUsers()).thenReturn(masterList);
		Assertions.assertEquals(masterList,crud.getAllUsers());
	}
	
	
	/* Display Account List by Group Name */
	
	@Test
	public void testDisplayAccountDetailsByGroupName() {
		when(crud.getAccountList()).thenReturn(list);
		when(crud.listAccountByGroupName( "bank")).thenReturn(list);
		Assertions.assertEquals(list,viewByGroup.getAccountByGroupName("bank") );
	}
	
	@Test
	public void testDisplayAccountDetailsByGroupNameWithNull() {
		when(crud.getAccountList()).thenReturn(list);
		
		lenient().when(crud.listAccountByGroupName(null)).thenReturn(list);
		List<Account> expected=list.stream().filter(account->account.getGroup().equals(null)).collect(Collectors.toList());
		Assertions.assertEquals(expected,viewByGroup.getAccountByGroupName(null) );
	}
	
	/* Update URL Test Cases */
	
	
	@Test
	public void testUpdateAccountByUrl_With_Correct_Details() {

		when(crud.getAccountList()).thenReturn(list);
		when(crud.updateAccountUrl("https://www.sbi.com","https://www.updated.com")).thenReturn(list);
		Assertions.assertEquals(list, modifyUrl.modifyUrl("https://www.sbi.com","https://www.updated.com"));
	}
	
	
	@Test
	public void testUpdateAccountByUrl_With_InCorrect_Details() {
		when(crud.getAccountList()).thenReturn(list);
		lenient().when(crud.updateAccountUrl("https://www.sbi","https://www.updated.com")).thenReturn(list);
		List<Account> expected=list.stream().filter(account->account.getUrl().equals("https://www.sbi")).collect(Collectors.toList());
		
		Assertions.assertEquals(expected, modifyUrl.modifyUrl("https://www.sbi","https://www.updated.com"));
	}
	
	 
	
	@Test
	public void testUpdateAccountByUrl_With_Null() {
		when(crud.getAccountList()).thenReturn(list);
		lenient().when(crud.updateAccountUrl(null,null)).thenReturn(list);
		List<Account> expected=list.stream().filter(account->account.getUrl().equals(null)).collect(Collectors.toList());
		
		Assertions.assertEquals(expected, modifyUrl.modifyUrl(null,null));
	}
	
	
	/* Update Password Test Cases */
	
	
	@Test
	public void testUpdateAccountByPassword_With_Correct_Details() {
		when(crud.getAccountList()).thenReturn(list);
		String enString=encryptdecrypt.Encrypt("UpdatedPassword");
		when(encryptdecrypt.Encrypt("UpdatedPassword")).thenReturn(enString);
		when(crud.updateAccountPassword("https://www.sbi.com",enString)).thenReturn(list);
		Assertions.assertEquals(list,modifyPassword.modifyPassword("https://www.sbi.com","UpdatedPassword"));
	}
	
	
	
	
	
	
	/* Delete Group Name Test Cases */
	
	@Test
	public void testDeleteAccountByGroup_With_Correct_Details() {
		when(crud.getAccountList()).thenReturn(list);
		when(crud.deleteAccountByGroupName("bank")).thenReturn(true);
	Assertions.assertEquals(true, deleteGroup.deleteAccountByGroup("bank"));
		
	}
	
	
	@Test
	public void testDeleteAccountByGroup_With_InCorrect_Details() {
		when(crud.getAccountList()).thenReturn(list);
		lenient().when(crud.deleteAccountByGroupName("empdh")).thenReturn(false);
	Assertions.assertEquals(false, deleteGroup.deleteAccountByGroup("empdh"));
	}
	
	
	@Test
	public void testDeleteAccountByGroup_With_Null_Details() {
		when(crud.deleteAccountByGroupName(null)).thenReturn(false);
	Assertions.assertFalse( crud.deleteAccountByGroupName(null));
		
	}
	
	
	
	/* Delete URL Test Cases */
	
	@Test
	public void testDeleteAccountByUrl_With_Correct_Details() {

		when(crud.deleteAccountByUrl("https://www.sbi.com")).thenReturn(true);
		Assertions.assertEquals(true, crud.deleteAccountByUrl("https://www.sbi.com"));
	}
	
	
	@Test
	public void testDeleteAccountByUrl_With_InCorrect_Details() {

		Assertions.assertEquals(false, crud.deleteAccountByUrl("https://www.sbi"));
	}
	
	
	@Test
	public void testDeleteAccountByUrl_With_Null_Details() {
		when(crud.deleteAccountByUrl(null)).thenReturn(true);

		Assertions.assertTrue(crud.deleteAccountByUrl(null));
	}
	
	

	
	
	
	
	
	/* Decoding Password Test Cases */
	
	@Test

	public void testPasswordIsDecryptedReturnTrue() {
		String password = "CKX5k3qZMv94/mthvcZIpw==";
		when(encryptdecrypt.Decrypt(password)).thenReturn("Manoj@123");
		assertEquals("Manoj@123", encryptdecrypt.Decrypt(password));
	}
	
	
	@Test

	public void testPasswordIsDecrypted() {
		String password = "CKX5k3qZMv94/mthvcZIpw==";
		Assertions.assertNotEquals("", encryptdecrypt.Decrypt(password));
	}
	
	
	@Test
	public void testEmptyPasswordIsDecryptedReturnTrue() {
		String password = "07RI3s/vhYkKf2GvA1kY/w==";
		when(encryptdecrypt.Decrypt(password)).thenReturn("");
		assertEquals("", encryptdecrypt.Decrypt(password));
	}
	
	
	@Test
	public void testEmptyPasswordIsDecrypted() {
		String password = "07RI3s/vhYkKf2GvA1kY/w==";
		Assertions.assertNotEquals("Manoj", encryptdecrypt.Decrypt(password));
	}
	
	
	
	
	/* Encoding Password Test Cases */
	
	@Test

	public void testPasswordIsEncryptedReturnTrue() {
		String password = "Manoj@123";
		when(encryptdecrypt.Encrypt(password)).thenReturn("CKX5k3qZMv94/mthvcZIpw==");
		assertEquals("CKX5k3qZMv94/mthvcZIpw==", encryptdecrypt.Encrypt(password));
	}
	
	
	@Test
	public void testEmptyPasswordIsEncryptedReturnTrue() {
		String password = "";
		when(encryptdecrypt.Encrypt(password)).thenReturn("07RI3s/vhYkKf2GvA1kY/w==");
		assertEquals("07RI3s/vhYkKf2GvA1kY/w==", encryptdecrypt.Encrypt(password));
	}
	
	
	
	@Test
	public void testNullPasswordIsEncrypted() {
		String password = null;
		Assertions.assertNull(null, encryptdecrypt.Encrypt(password));
	}
	
	
	
	/* Validation Of URL and Password TestCases */
	
	
	@Test

	public void ifInCorrectPasswordAndUrlReturnFalse() {
		String password = "manoj";
		String url = "ww.demo";
		when(validationPassword.validPassword(password)).thenReturn(false);
		assertFalse(validationPassword.validPassword(password));
		when(validationUrl.isValidURL(url)).thenReturn(false);
		assertFalse(validationUrl.isValidURL(url));
	}

	
	
	@Test

	public void ifCorrectPasswordAndUrlReturnTrue() {
		String inputPassword = "Manoj@123";
		String url = "https://www.geeksforgeeks.org";
		when(validationPassword.validPassword(inputPassword)).thenReturn(true);
		assertTrue(validationPassword.validPassword(inputPassword));
		when(validationUrl.isValidURL(url)).thenReturn(true);
		assertTrue(validationUrl.isValidURL(url));
	}

	
	@Test

	public void ifInCorrectPasswordAndCorrectUrl() {
		String password = "manoj";
		String url = "https://www.geeksforgeeks.org";
		when(validationPassword.validPassword(password)).thenReturn(false);
		assertFalse(validationPassword.validPassword(password));
		when(validationUrl.isValidURL(url)).thenReturn(true);
		assertTrue(validationUrl.isValidURL(url));
	}

	
	
	@Test

	public void ifCorrectPasswordAndInCorrectUrl() {
		String password = "Demo@1234";
		String url = "www.geeksforgeeks.org";
		when(validationPassword.validPassword(password)).thenReturn(true);
		assertTrue(validationPassword.validPassword(password));
		when(validationUrl.isValidURL(url)).thenReturn(false);
		assertFalse(validationUrl.isValidURL(url));
	}

	
	@Test

	public void ifNullUrl() {
		String password = "Demo@1234";
		String url = null;
		when(validationPassword.validPassword(password)).thenReturn(true);

		assertTrue(validationPassword.validPassword(password));
		when(validationUrl.isValidURL(url)).thenReturn(false);

		assertFalse(validationUrl.isValidURL(url));
	}

	
	@Test

	public void ifNullPassword() {
		String password = "";
		String url = "";
		when(validationPassword.validPassword(password)).thenReturn(false);

		assertFalse(validationPassword.validPassword(password));
		when(validationUrl.isValidURL(url)).thenReturn(false);

		assertFalse(validationUrl.isValidURL(url));
	}

	
	@Test

	public void ifPasswordReturnsTrue() {
		String password = "Manoj@1";
		String url = "";
		when(validationPassword.validPassword(password)).thenReturn(true);

		Assertions.assertEquals(true, validationPassword.validPassword(password));
		when(validationUrl.isValidURL(url)).thenReturn(false);

		assertFalse(validationUrl.isValidURL(url));
	}
	

}





