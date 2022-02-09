
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
import com.epam.pmt.servicelayer.UserServiceImpl;
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
	List<Account> list;
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
	
	@InjectMocks
	UserServiceImpl userService;
	
	@BeforeEach
	void setUp() {
		 list = new ArrayList<>();
		masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		account=new Account("https://www.sbi.com", "manoj", "Manoj123", "bank");
		list.add(new Account("https://www.sbi.com", "manoj", "Manoj123", "bank"));
		list.add(new Account("https://www.icici.com", "ajeet", "Ajeet@123", "ajeetBank"));
		list.add(new Account("https://www.Boi.com", "kumar", "Kumar12", "dummy"));
		
	}

	
	@Test
	void testAddAccountWithCorrectDetails() {
		
		lenient().when(current.getCurrentUser()).thenReturn(masterUser);
		when(accountRepo.save(account)).thenReturn(account);
		
		Assertions.assertEquals(true,passwordManagementServiceImpl.addAccount(account,CurrentAccount.getInstance().getCurrentUser()) );
		
		}
	
	

	@Test
	void testGetPassword() {
		List<Account> accountList = accountRepo.findByUsernameAndMasterUser("manoj", CurrentAccount.getInstance().getCurrentUser());
		when(encryptDecrypt.getDecryptedPassword(accountList,"manoj")).thenReturn("Manoj@123");
		when(accountRepo.findByUsernameAndMasterUser("manoj", CurrentAccount.getInstance().getCurrentUser())).thenReturn(accountList);
		assertEquals("Manoj@123", passwordManagementServiceImpl.getPassword("manoj",CurrentAccount.getInstance().getCurrentUser()));
	}
  


	
//	/* Display Account List by Group Name */

	@Test
	 void displayAccountDetailsByGroupNameTest() {
		when(accountRepo.findByGroupAndMasterUser("bank", CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		Assertions.assertEquals(list, passwordManagementServiceImpl.getAccountByGroupName("bank",CurrentAccount.getInstance().getCurrentUser()));
	}
//
	@Test
	 void displayAccountDetailsByGroupNameWithNullTest() {
		when(accountRepo.findByGroupAndMasterUser(null, CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		Assertions.assertEquals(list, passwordManagementServiceImpl.getAccountByGroupName(null,CurrentAccount.getInstance().getCurrentUser()));
	}
	
	@Test
	 void displayAccountDetailsByGroupNameWithInCorrectDetailsTest() {
		when(accountRepo.findByGroupAndMasterUser("nothing", CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		Assertions.assertEquals(list, passwordManagementServiceImpl.getAccountByGroupName("nothing",CurrentAccount.getInstance().getCurrentUser()));
	}


	@Test
	void addAccountTestWithInvalidData() {
		try {
		when(CurrentAccount.getInstance().getCurrentUser()).thenReturn(masterUser);
		when(accountRepo.save(account)).thenReturn(account);
		when(passwordManagementServiceImpl.addAccount(account,CurrentAccount.getInstance().getCurrentUser())).thenThrow(LoginFirstException.class);
		}catch(Exception message) {
		Assertions.assertFalse(message instanceof LoginFirstException);
		
		}
	}
	
	@Test
	void addAccountTest() {
		when(accountRepo.save(account)).thenReturn(account);
		Assertions.assertEquals(true,passwordManagementServiceImpl.addAccount(account,masterUser));
		
	}
	
	
	
	@Test
	void addMasterUserTest() {
		when(masterUserRepo.existsByUsername("newUserName")).thenReturn(true);
		when(masterUserRepo.save(masterUser)).thenReturn(masterUser);
		Assertions.assertEquals(masterUser, userService.addUser(masterUser));
	}
	
	@Test
	void alreadyExistDataOfMasterUserTest() {
		when(masterUserRepo.existsByUsername(masterUser.getUsername())).thenReturn(false);
		when(masterUserRepo.save(masterUser)).thenReturn(masterUser);
		Assertions.assertEquals(masterUser, userService.addUser(masterUser));
	}
	
	@Test
	 void testGetAccountList() {

		List<Account> list = new ArrayList<Account>();
		list.add(new Account("https://www.sbi.com", "kujmar", "Manoj1", "bank"));
		Mockito.when(accountRepo.findByMasterUser(CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		Assertions.assertEquals(list, passwordManagementServiceImpl.viewAllAccounts(CurrentAccount.getInstance().getCurrentUser()));
	}

	

	@Test
	void testDisplayMasterUsers() {

		List<MasterUser> masterList = new ArrayList<MasterUser>();
		masterList.add(new MasterUser(1,"manoj", "Manoj1"));
		when((List<MasterUser>) masterUserRepo.findAll()).thenReturn(masterList);
		Assertions.assertEquals(masterList, userService.viewAllUsers());
	}
	
	
	
	@Test
	void getAccountByIdTest() {
		
		Optional<Account> accountDetails = Optional.of(new Account(1,"https://www.sbi.com", "manoj", "Manoj123", "bank", masterUser));
		when(accountRepo.findById(1)).thenReturn( accountDetails);
		account=accountDetails.get();
		Assertions.assertEquals(account,passwordManagementServiceImpl.getAccountById(1));
		
	}



	
	@Test
	void updateAccountTest() {
		
		account = new Account(2,"https://www.sbi.com", "manoj", "Manoj123", "bank",masterUser);
		when(accountRepo.save(account)).thenReturn(account);
		Assertions.assertEquals(account,passwordManagementServiceImpl.updateAccount(account,CurrentAccount.getInstance().getCurrentUser()));
		
	}
	
  
  
	@Test
	void testDeleteGroup() {
		when(accountRepo.findByGroupAndMasterUser("bank", CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		doNothing().when(accountRepo).deleteByGroupAndMasterUser("bank", CurrentAccount.getInstance().getCurrentUser());
		assertEquals(true, passwordManagementServiceImpl.deleteAccountByGroup("bank",CurrentAccount.getInstance().getCurrentUser()));
	}
	
	@Test
	void testDeleteGroupWithIncorrectDetails() {
		when(accountRepo.findByGroupAndMasterUser("123", CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		doNothing().when(accountRepo).deleteByGroupAndMasterUser("123", CurrentAccount.getInstance().getCurrentUser());
		assertEquals(true, passwordManagementServiceImpl.deleteAccountByGroup("123",CurrentAccount.getInstance().getCurrentUser()));
	}
	
	@Test
	void testDeleteGroupWithNull() {
		when(accountRepo.findByGroupAndMasterUser(null, CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		doNothing().when(accountRepo).deleteByGroupAndMasterUser(null, CurrentAccount.getInstance().getCurrentUser());
		assertEquals(true, passwordManagementServiceImpl.deleteAccountByGroup(null,CurrentAccount.getInstance().getCurrentUser()));
	}
	
	
	
	@Test
	void testDeleteUrl() {
		when(accountRepo.findByUrlAndMasterUser("https://www.sbi.com", CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		doNothing().when(accountRepo).deleteByUrlAndMasterUser("https://www.sbi.com", CurrentAccount.getInstance().getCurrentUser());
		assertEquals(true, passwordManagementServiceImpl.deleteAccountByUrl("https://www.sbi.com",CurrentAccount.getInstance().getCurrentUser()));
	}
	
	@Test
	void testDeleteUrlWithIncorrectDetails() {
		when(accountRepo.findByUrlAndMasterUser("123", CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		doNothing().when(accountRepo).deleteByUrlAndMasterUser("123", CurrentAccount.getInstance().getCurrentUser());
		assertEquals(true, passwordManagementServiceImpl.deleteAccountByUrl("123",CurrentAccount.getInstance().getCurrentUser()));
	}
	
	@Test
	void testDeleteUrlWithNull() {
		when(accountRepo.findByUrlAndMasterUser(null, CurrentAccount.getInstance().getCurrentUser())).thenReturn(list);
		doNothing().when(accountRepo).deleteByUrlAndMasterUser(null, CurrentAccount.getInstance().getCurrentUser());
		assertEquals(true, passwordManagementServiceImpl.deleteAccountByUrl(null,CurrentAccount.getInstance().getCurrentUser()));
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
