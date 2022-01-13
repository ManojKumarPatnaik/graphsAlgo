package com.epam.pmt.testcases;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import com.epam.pmt.databaselayer.AccountDataBase;
import com.epam.pmt.entity.Account;
import com.epam.pmt.interfaceimplemetation.CreateAccountDetails;

public class TestCreate {
	ArrayList<Account> account1=new ArrayList<>();
	AccountDataBase accountDataBase;
	CreateAccountDetails createAccountService;
	@BeforeEach
	void testC() {
	account1.add(new Account("https://www.sbi.com", "manoj", "Manoj1", "bank"));
	createAccountService=new CreateAccountDetails();
	accountDataBase=new AccountDataBase();
	accountDataBase.setAccountList(account1);
	}

//	@Test
//	public void testCreate() {
//		Assertions.assertSame(createAccountService.add(new Account("https://www.sbi.com", "kumar", "Manoj1", "bank")));
//	}

}



	

