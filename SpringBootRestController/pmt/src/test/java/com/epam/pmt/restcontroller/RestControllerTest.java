package com.epam.pmt.restcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.pmt.dto.AccountDto;
import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.repo.AccountRepo;
import com.epam.pmt.servicelayer.PasswordManagementServiceImpl;
import com.epam.pmt.servicelayer.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class RestControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	PasswordManagementServiceImpl passwordManagementServiceImpl;
	List<Account> accounts;
	MasterUser masterUser;
	Account account;
	@MockBean
	AccountRepo accountRepo;
	AccountDto accountDto;
	@MockBean
	UserServiceImpl userService;
	@MockBean
	EncryptDecryptPassword encryptDecryptPassword;
	String json;
	ObjectMapper objectMapper;
	String encryptPassword;

	@BeforeEach
	void setUp() {
		masterUser = new MasterUser(1, "ManojKumar", "Manoj@123");
		accounts = new ArrayList<>();
		accounts.add(new Account(1, "https://www.sbi.com", "manoj", "Manoj123", "bank",masterUser));
		accounts.add(new Account(2, "https://www.icici.com", "ajeet", "Ajeet@123", "ajeetBank",masterUser));
		accountDto = new AccountDto();
		accountDto.setAccountId(1);
		accountDto.setGroup("Google");
		accountDto.setUrl("https://www.gmail.com");
		accountDto.setUsername("ManojKumar");
		accountDto.setPassword("Manoj@123");
		objectMapper = new ObjectMapper();
		when(userService.getMasterUserById(1)).thenReturn(masterUser);
		encryptPassword = encryptDecryptPassword.encrypt(accountDto.getPassword());

	}

	

	@Test
	void viewAccountTest() throws Exception {
		String uri = "/pmt/viewaccounts/1";
		when(passwordManagementServiceImpl.viewAllAccounts(masterUser)).thenReturn(accounts);
		json = objectMapper.writeValueAsString(accounts);
		mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isOk());
	}

	

	@Test
	void registerationTest() throws Exception {
		when(userService.addUser(masterUser)).thenReturn(masterUser);
		json = objectMapper.writeValueAsString(masterUser);
		mockMvc.perform(post("/pmt/").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isOk());

	}

	@Test
	void loginTest() throws Exception {
		when(userService.validateLoginDetails(masterUser.getUsername(), masterUser.getPassword())).thenReturn(true);
		json = objectMapper.writeValueAsString(masterUser);
		mockMvc.perform(post("/pmt/login")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json))
				.andExpect(status().isOk());

	}

	@Test
	void updateAccountTest() throws Exception {
		String uri = "/pmt/updateaccount/1/1";
		when(encryptDecryptPassword.encrypt(accountDto.getPassword())).thenReturn(encryptPassword);
		when(passwordManagementServiceImpl.getAccountById(1)).thenReturn(account);
		account = new Account(accountDto.getAccountId(), accountDto.getUrl(), accountDto.getUsername(),
				accountDto.getPassword(), accountDto.getGroup());
		when(passwordManagementServiceImpl.updateAccount(account, masterUser)).thenReturn(account);
		json = objectMapper.writeValueAsString(account);
		mockMvc.perform(put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isOk());
	}

	
	
	@Test
	void viewUsersTest() throws Exception {
		String uri = "/pmt/users";
		List<MasterUser> users=userService.viewAllUsers();
		when(userService.viewAllUsers()).thenReturn(users);
		json = objectMapper.writeValueAsString(users);
		mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andExpect(status().isOk());
	}
	

	@Test
	void getPasswordTest() throws Exception {
		String uri = "/pmt/readpassword/1?username=ManojKumar";
		when(passwordManagementServiceImpl.getPassword("ManojKumar", masterUser)).thenReturn("Manoj@123");
		mockMvc.perform(post(uri).content("Manoj@123"))
		.andExpect(status().isOk());
	}

	

	@Test
	void sortByGroupTest() throws Exception {
		String uri = "/pmt/sortbygroup/1?group=Google";
		when(passwordManagementServiceImpl.getAccountByGroupName("Google", masterUser)).thenReturn(accounts);
		json = objectMapper.writeValueAsString(accounts);
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
		.andExpect(status().isOk());
	}
	@Test
	void deleteGroupTest() throws Exception {
		String uri = "/pmt/deletegroup/1?group=bank";
		when(passwordManagementServiceImpl.deleteAccountByGroup("bank",masterUser)).thenReturn(true);
		json = objectMapper.writeValueAsString("Account group deleted Successfully");
		mockMvc.perform(delete(uri).content(json))
		.andExpect(status().isOk());
	}
	
	@Test
	void deleteUrlTest() throws Exception {
		String uri = "/pmt/deleteurl/1?url=https://www.gmail.com";
		when(passwordManagementServiceImpl.deleteAccountByUrl("https://www.gmail.com",masterUser)).thenReturn(true);
		mockMvc.perform(delete(uri)
				.content("Account url deleted Successfully"))
		.andExpect(status().isOk());
	}
	
	
	
	
	
	@Test
	void addAccountTest() throws Exception {
		when(encryptDecryptPassword.encrypt(accountDto.getPassword())).thenReturn(encryptPassword);
		when(userService.getMasterUserById(1)).thenReturn(masterUser);
		Account account = new Account(accountDto.getUrl(), accountDto.getUsername(), accountDto.getPassword(),
				accountDto.getGroup());
		when(passwordManagementServiceImpl.addAccount(account, masterUser)).thenReturn(true);
		json = objectMapper.writeValueAsString(account);
		mockMvc.perform(post("/pmt/viewaccounts/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json))
				.andExpect(status().isOk());
	}
	
	
	
	
	
	
	@Test
	void deleteUrlWithInvalidTest() throws Exception {
		String uri = "/pmt/deleteurl/1?url=2636";
		when(passwordManagementServiceImpl.deleteAccountByUrl(null,masterUser)).thenReturn(false);
		mockMvc.perform(delete(uri)
				.content("Unable to find the Url."))
		.andExpect(status().isNotFound());
	}
	
	
	
	@Test
	void deleteGroupWithInvalidTest() throws Exception {
		String uri = "/pmt/deletegroup/1?group=null";
		when(passwordManagementServiceImpl.deleteAccountByGroup(null,masterUser)).thenReturn(false);
		mockMvc.perform(delete(uri).content( "Unable to find group name."))
		.andExpect(status().isNotFound());
	}
	
	
	@Test
	void viewAccountInvalidTest() throws Exception {
		String uri = "/pmt/viewaccounts";
		when(passwordManagementServiceImpl.viewAllAccounts(masterUser)).thenReturn(accounts);
		json = objectMapper.writeValueAsString(accounts);
		mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isNotFound());
	}
	
	@Test
	void addAccountWithInvalidDataTest() throws Exception {
		when(encryptDecryptPassword.encrypt(null)).thenReturn(null);
		when(userService.getMasterUserById(1)).thenReturn(masterUser);
		
		when(passwordManagementServiceImpl.addAccount(null, masterUser)).thenReturn(false);
		json = objectMapper.writeValueAsString("Unable to create an account");
		mockMvc.perform(post("/pmt/viewaccounts/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json))
				.andExpect(status().isInternalServerError());
	}

	
	
	@Test
	void sortByGroupWithInvalidDataTest() throws Exception {
		String uri = "/pmt/sortbygroup/1";
		when(passwordManagementServiceImpl.getAccountByGroupName(null, masterUser)).thenReturn(null);
		json = objectMapper.writeValueAsString(null);
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
		.andExpect(status().isInternalServerError());
	}
	
}
