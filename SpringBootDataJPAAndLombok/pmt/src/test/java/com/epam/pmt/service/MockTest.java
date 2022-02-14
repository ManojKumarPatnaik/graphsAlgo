
package com.epam.pmt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.LoginFirstException;
import com.epam.pmt.repo.AccountRepo;
import com.epam.pmt.repo.MasterUserRepo;
import com.epam.pmt.servicelayer.PasswordManagementServiceImpl;
import com.epam.pmt.utils.CurrentAccount;
import com.epam.pmt.validation.AccountValidation;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class MockTest {
	@InjectMocks
	PasswordManagementServiceImpl passwordManagementServiceImpl;
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
	@MockBean
	AccountRepo accountRepo;
	@MockBean
	MasterUserRepo masterUserRepo;
	
	@BeforeEach
	void setUp() {
		masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		list.add(new Account("https://www.sbi.com", "manoj", "Manoj123", "bank"));
		list.add(new Account("https://www.icici.com", "ajeet", "Ajeet@123", "ajeetBank"));
		list.add(new Account("https://www.Boi.com", "kumar", "Kumar12", "dummy"));
		
	}

	

	@Test
	 void testGetAccountList() {

		List<Account> list = new ArrayList<Account>();
		list.add(new Account("https://www.sbi.com", "kujmar", "Manoj1", "bank"));
		Mockito.when(accountRepo.findByMasterUser(CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		Assertions.assertEquals(list, passwordManagementServiceImpl.viewAllAccounts());
	}

	

	@Test
	void testDisplayMasterUsers() {

		List<MasterUser> masterList = new ArrayList<MasterUser>();
		masterList.add(new MasterUser("manoj", "Manoj1"));
		when((List<MasterUser>) masterUserRepo.findAll()).thenReturn(masterList);
		Assertions.assertEquals(masterList, passwordManagementServiceImpl.viewAllUsers());
	}

//	/* Display Account List by Group Name */

	@Test
	 void testDisplayAccountDetailsByGroupName() {
		when(accountRepo.findByGroupAndMasterUser("bank", CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		Assertions.assertEquals(list, passwordManagementServiceImpl.getAccountByGroupName("bank"));
	}
//
	@Test
	 void testDisplayAccountDetailsByGroupNameWithNull() {
		when(accountRepo.findByGroupAndMasterUser(null, CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		Assertions.assertEquals(list, passwordManagementServiceImpl.getAccountByGroupName(null));
	}
	
	@Test
	 void testDisplayAccountDetailsByGroupNameWithInCorrectDetails() {
		when(accountRepo.findByGroupAndMasterUser("nothing", CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		Assertions.assertEquals(list, passwordManagementServiceImpl.getAccountByGroupName("nothing"));
	}

	
	@Test
	void testAddAccount() {
		try {
		when(CurrentAccount.getInstance().getCurrentUser()).thenReturn(masterUser);
		when(accountRepo.save(account)).thenReturn(account);
		when(passwordManagementServiceImpl.addAccount(account)).thenThrow(LoginFirstException.class);
		}catch(Exception message) {
		Assertions.assertFalse(message instanceof LoginFirstException);
		
		}
	}
	
	@Test
	void testAddAccountWithCorrectDetails() {
		
		lenient().when(current.getCurrentUser()).thenReturn(masterUser);
		doNothing().when(account).setMasterUser(masterUser);
		when(accountRepo.save(account)).thenReturn(account);
		
		Assertions.assertEquals(true,passwordManagementServiceImpl.addAccount(account) );
		
		}
	
	
	
//	
//	
	
	
	@Test
	void getAccountByIdTest() {
		
		Optional<Account> accountDetails = Optional.of(new Account(1,"https://www.sbi.com", "manoj", "Manoj123", "bank", masterUser));
		when(accountRepo.findById(1)).thenReturn( accountDetails);
		account=accountDetails.get();
		Assertions.assertEquals(account,passwordManagementServiceImpl.getAccountById(1));
		
	}



	

	
  
  
	
	@Test
	void testGetPassword() {
		List<Account> accountList = accountRepo.findByUsernameAndMasterUser("manoj", CurrentAccount.getInstance().getCurrentUser());
		when(encryptDecrypt.getDecryptedPassword(accountList,"manoj")).thenReturn("Manoj@123");
		when(accountRepo.findByUsernameAndMasterUser("manoj", CurrentAccount.getInstance().getCurrentUser())).thenReturn(accountList);
		assertEquals("Manoj@123", passwordManagementServiceImpl.getPassword("manoj"));
	}
  



	
	
	
	
//	
//	
// /* Decoding Password Test Cases*/
//
	@Test
	 void testPasswordIsDecryptedReturnTrue() {
		String password = "CKX5k3qZMv94/mthvcZIpw==";
		when(encryptdecrypt.decrypt(password)).thenReturn("Manoj@123");
		assertEquals("Manoj@123", encryptdecrypt.decrypt(password));
	}

	@Test

	 void testPasswordIsDecrypted() {
		String password = "CKX5k3qZMv94/mthvcZIpw==";
		Assertions.assertNotEquals("", encryptdecrypt.decrypt(password));
	}

	@Test
	 void testEmptyPasswordIsDecryptedReturnTrue() {
		String password = "07RI3s/vhYkKf2GvA1kY/w==";
		when(encryptdecrypt.decrypt(password)).thenReturn("");
		assertEquals("", encryptdecrypt.decrypt(password));
	}

	@Test
	 void testEmptyPasswordIsDecrypted() {
		String password = "07RI3s/vhYkKf2GvA1kY/w==";
		Assertions.assertNotEquals("Manoj", encryptdecrypt.decrypt(password));
	}

	/* Encoding Password Test Cases */

	@Test
	void testPasswordIsEncryptedReturnTrue() {
		String password = "Manoj@123";
		when(encryptdecrypt.decrypt(password)).thenReturn("CKX5k3qZMv94/mthvcZIpw==");
		assertEquals("CKX5k3qZMv94/mthvcZIpw==", encryptdecrypt.decrypt(password));
	}

	@Test
	void testEmptyPasswordIsEncryptedReturnTrue() {
		String password = "";
		when(encryptdecrypt.decrypt(password)).thenReturn("07RI3s/vhYkKf2GvA1kY/w==");
		assertEquals("07RI3s/vhYkKf2GvA1kY/w==", encryptdecrypt.decrypt(password));
	}

	@Test
	void testNullPasswordIsEncrypted() {
		String password = null;
		Assertions.assertNull(null, encryptdecrypt.decrypt(password));
	}

	/* Validation Of URL and Password TestCases */

	@Test
	 void ifInCorrectPasswordAndUrlReturnFalse() {
		String password = "manoj";
		String url = "ww.demo";
		when(validationPassword.validPassword(password)).thenReturn(false);
		assertFalse(validationPassword.validPassword(password));
		when(accountValidation.isValidURL(url)).thenReturn(false);
		assertFalse(accountValidation.isValidURL(url));
	}

	@Test
	 void ifCorrectPasswordAndUrlReturnTrue() {
		String inputPassword = "Manoj@123";
		String url = "https://www.geeksforgeeks.org";
		when(validationPassword.validPassword(inputPassword)).thenReturn(true);
		assertTrue(validationPassword.validPassword(inputPassword));
		when(accountValidation.isValidURL(url)).thenReturn(true);
		assertTrue(accountValidation.isValidURL(url));
	}

	@Test
	 void ifInCorrectPasswordAndCorrectUrl() {
		String password = "manoj";
		String url = "https://www.geeksforgeeks.org";
		when(validationPassword.validPassword(password)).thenReturn(false);
		assertFalse(validationPassword.validPassword(password));
		when(accountValidation.isValidURL(url)).thenReturn(true);
		assertTrue(accountValidation.isValidURL(url));
	}

	@Test
	 void ifCorrectPasswordAndInCorrectUrl() {
		String password = "Demo@1234";
		String url = "www.geeksforgeeks.org";
		when(validationPassword.validPassword(password)).thenReturn(true);
		assertTrue(validationPassword.validPassword(password));
		when(accountValidation.isValidURL(url)).thenReturn(false);
		assertFalse(accountValidation.isValidURL(url));
	}

	@Test
	 void ifNullUrl() {
		String password = "Demo@1234";
		String url = null;
		when(validationPassword.validPassword(password)).thenReturn(true);

		assertTrue(validationPassword.validPassword(password));
		when(accountValidation.isValidURL(url)).thenReturn(false);

		assertFalse(accountValidation.isValidURL(url));
	}

	@Test
	 void ifNullPassword() {
		String password = "";
		String url = "";
		when(validationPassword.validPassword(password)).thenReturn(false);

		assertFalse(validationPassword.validPassword(password));
		when(accountValidation.isValidURL(url)).thenReturn(false);

		assertFalse(accountValidation.isValidURL(url));
	}

	@Test
	 void ifPasswordReturnsTrue() {
		String password = "Manoj@1";
		String url = "";
		when(validationPassword.validPassword(password)).thenReturn(true);

		Assertions.assertEquals(true, validationPassword.validPassword(password));
		when(accountValidation.isValidURL(url)).thenReturn(false);

		assertFalse(accountValidation.isValidURL(url));
	}

}
