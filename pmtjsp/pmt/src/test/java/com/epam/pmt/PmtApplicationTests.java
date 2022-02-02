package com.epam.pmt;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.presentationlayer.CurrentAccount;
import com.epam.pmt.presentationlayer.Login;
import com.epam.pmt.presentationlayer.MasterAccount;
import com.epam.pmt.servicelayer.CrudOperationsServiceImpl;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;



@SpringBootTest
@AutoConfigureMockMvc
class PmtApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	CrudOperationsServiceImpl crudOperationsServiceImpl;
	@MockBean
	CurrentAccount currentAccount;
	@MockBean
	MasterAccount masterAccount;
	@MockBean
	ValidateUserName validateUserName;
	@MockBean
	ValidationPassword validationPassword;
	@MockBean
	Login login;
	@MockBean
	MasterUser masterUser;
	@MockBean
	Account account;
	
	
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	
	@Test
	void testExistingAccountView() throws Exception
	{
		MasterUser masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		mockMvc.perform(get("/viewAccount")).andExpect(status().isOk())
		.andExpect(view().name("viewAccount"));
	}
	
	@Test
	void testDoAddAccount() throws Exception
	{
		MasterUser masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		mockMvc.perform(get("/createAccount")).andExpect(view().name("createAccount"));
	}
	
	@Test
	void testHome() throws Exception
	{
		mockMvc.perform(get("/")).andExpect(view().name("welcome"));
	}
	
	@Test
	void testRegister() throws Exception
	{
		mockMvc.perform(get("/masterUserRegister")).andExpect(view().name("register"));
	}
	
	@Test
	void testWelcome() throws Exception
	{
		mockMvc.perform(get("/welcome")).andExpect(view().name("welcome"));
	}
	@Test
	void testLogin() throws Exception
	{
		mockMvc.perform(get("/login")).andExpect(view().name("login"));
	}
	
	@Test
	void testDoRegister() throws Exception
	{
		when(validateUserName.isValidUserName("manoj")).thenReturn(true);
		when(validationPassword.validPassword("Manoj@123")).thenReturn(true);
		when(masterAccount.addMasterUser("manoj","Manoj@123")).thenReturn(true);
		mockMvc.perform(post("/masterUserRegister")).andExpect(view().name("masterUserRegister"));
	}
	
	@Test
	void testLogOut() throws Exception
	{
		mockMvc.perform(get("/logout")).andExpect(view().name("welcome"));
	}
	
	@Test
	void testViewAllUsers() throws Exception
	{
		mockMvc.perform(get("/viewAllUsers")).andExpect(view().name("viewAllUsers"));
	}
	
	@Test
	void testViewAllUsersWithValidData() throws Exception
	{
		List<Account> accountList=new ArrayList<>();
		accountList.add(new Account("https://www.sbi.com", "manoj", "Manoj123", "bank"));
		when(crudOperationsServiceImpl.viewAllAccounts()).thenReturn(accountList);
		mockMvc.perform(get("/viewAllUsers")).andExpect(view().name("viewAllUsers"));
	}
	
	
	@Test
	void testViewAccount() throws Exception
	{
		List<Account> accountList=new ArrayList<>();
		accountList.add(new Account("https://www.sbi.com", "manoj", "Manoj123", "bank"));
		when(crudOperationsServiceImpl.viewAllAccounts()).thenReturn(accountList);    
		mockMvc.perform(post("/viewAccount")).andExpect(view().name("viewAccount"));
	}
	
	
	@Test
	void testMenu() throws Exception
	{
		MasterUser masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		mockMvc.perform(get("/menu")).andExpect(view().name("menu"));
	}
	
	
	@Test
	void testDeleteByUrl() throws Exception
	{
		MasterUser masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		mockMvc.perform(delete("/deleteUrl")).andExpect(view().name("viewAccount"));
	}
	
	@Test
	void testReadPasswrd() throws Exception
	{
		MasterUser masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		mockMvc.perform(get("/read")).andExpect(view().name("read"));
	}
	
	@Test
	void testSortbygroup() throws Exception
	{
		MasterUser masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		mockMvc.perform(get("/sortbygroup")).andExpect(view().name("sortbygroup"));
	}
	
	@Test
	void testEditAccount() throws Exception
	{
		MasterUser masterUser=new MasterUser(1,"manoj","Manoj@123");
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		mockMvc.perform(get("//edit/{1}")).andExpect(view().name("/edit/{id}"));
	}
	
	@Test
	void testAddAccount() throws Exception
	{
		Account account = new Account();
		account.setGroup("Google");
		account.setUrl("http://www.gmail.com/");
		account.setUsername("manoj");
		account.setPassword("Manoj@123");
		when(crudOperationsServiceImpl.addAccount(account)).thenReturn(true);    
		mockMvc.perform(post("/createAccount")).andExpect(view().name("createAccount"));
	}
	
	
	

	@Test
	void testDoLogin() throws Exception
	{
		List<MasterUser> current = new ArrayList<>() ;
		current.add(new MasterUser(1,"manoj","Manoj@123"));
		MasterUser masterUser=new MasterUser(1,"manoj","Manoj@123");
		
		when(login.validateLoginDetails(masterUser.getUsername(), masterUser.getPassword())).thenReturn(true);
		when( crudOperationsServiceImpl.viewAllUsers().stream()
				.filter(account -> account.getUsername().equals(masterUser.getUsername())
						&& account.getPassword().equals(masterUser.getPassword()))
				.collect(Collectors.toList()).get(0)).thenReturn(masterUser);
		CurrentAccount.getInstance().setCurrentUser(masterUser);
		mockMvc.perform(post("/login")).andExpect(view().name("viewAccount"));
	}
	
	
	
	
	
	
	
}
