package com.epam.pmt.junittestcases;
//package com.epam.pmt.testcases;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.epam.pmt.entity.Account;
//import com.epam.pmt.persistencelayer.CreateAccountDetails;
//import com.epam.pmt.persistencemanager.CrudOperations;
////
//public class TestCreate {
//	
//	
//	CrudOperations crud;
//	CreateAccountDetails createAccountDetails;
//	Account account;
//	@BeforeEach
//	void test() {
//		crud=new CrudOperations();
//		createAccountDetails=new CreateAccountDetails();
//		account=new Account();
//		account.setUsername("manoj");
//		account.setGroup("bank");
//		account.setPassword("Manoj123");
//		account.setUrl("https://www.sbi.com");
//	}
//
//	
//
//	
//	@Test
//	void testCreateAccountWithValidDataReturnTrue() {
//		
//		
//		
//		Assertions.assertTrue(createAccountDetails.add(account));
//
//		
//	}
//	
//	
//	@Test
//	void testCreateAccountWithIncorrectDataReturnFalse() {
//		
//		Assertions.assertFalse(createAccountDetails.add(new Account("https://www.sbi", "manoj", "Manoj1", "bank")));
//		
//		
//	}
//	
//	@Test
//	void testCreateAccountWithNull() {
//		
//		Assertions.assertEquals(true, createAccountDetails.add(null));
//		
//		
//	}
//	
//}
//
