package com.epam.pmt.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.pmt.dto.AccountDto;
import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.servicelayer.PasswordManagementServiceImpl;
import com.epam.pmt.servicelayer.UserServiceImpl;
@RestController
@RequestMapping("/pmt")
public class AccountRestController {
	
	@Autowired
	PasswordManagementServiceImpl passwordManagementServiceImpl;
	@Autowired
	EncryptionAndDecryption encryptionAndDecryption;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/viewaccounts/{id}")
	public  ResponseEntity<List<Account>> viewAccounts( @PathVariable("id") int current) {
		
		MasterUser currentUser=userService.getMasterUserById(current);
		
		return new ResponseEntity<>(passwordManagementServiceImpl.viewAllAccounts(currentUser),HttpStatus.OK);
	}
	
	@PostMapping("/viewaccounts/{id}")
	public ResponseEntity<String> createAccount(@RequestBody  @Valid AccountDto accountDto,  @PathVariable("id") int current) {
		boolean isAdded=false;
		MasterUser currentUser=userService.getMasterUserById(current);

			String encrypt = encryptDecryptPassword.encrypt(accountDto.getPassword());
			Account accountInfo = new Account(accountDto.getUrl(), accountDto.getUsername(), encrypt, accountDto.getGroup());
			isAdded=passwordManagementServiceImpl.addAccount(accountInfo,currentUser);
		return new ResponseEntity<>(isAdded?"Account Created Successfully!":"Unable to create an account", HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletegroup/{id}")
	public  ResponseEntity<String>  deleteGroup(@RequestParam String group , @PathVariable("id") int current) {
		boolean isDeleted=false;
		MasterUser currentUser=userService.getMasterUserById(current);
		if(passwordManagementServiceImpl.deleteAccountByGroup(group,currentUser)) {
			isDeleted=true;
			
		}
		return new ResponseEntity<>(isDeleted?"Account group deleted Successfully": "Unable to find the group name.", isDeleted? HttpStatus.OK :HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deleteurl/{id}")
	public  ResponseEntity<String>  deleteUrl(@RequestParam  String url,  @PathVariable("id") int current) {
		boolean isDeleted=false;
		MasterUser currentUser=userService.getMasterUserById(current);
		if(passwordManagementServiceImpl.deleteAccountByUrl(url,currentUser)) {
			isDeleted=true;
			
		}

		return new ResponseEntity<>(isDeleted?"Account url deleted Successfully": "Unable to find the Url.", isDeleted? HttpStatus.OK :HttpStatus.NOT_FOUND);
	}
	
	
	
	@PostMapping("/sortbygroup/{id}")
	public  ResponseEntity<List<Account>>  sortByGroup(@RequestParam String group,  @PathVariable("id") int current) {
		MasterUser currentUser=userService.getMasterUserById(current);
		List<Account> account=passwordManagementServiceImpl.getAccountByGroupName(group,currentUser);

		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@PostMapping("/readpassword/{id}")
	public  ResponseEntity<Object>  getPassword(@RequestParam String username,  @PathVariable("id") int current) {
		MasterUser currentUser=userService.getMasterUserById(current);
		String password = passwordManagementServiceImpl.getPassword( username,currentUser);
		
		return new ResponseEntity<>(password==null?"Please Enter valid username.":password, HttpStatus.OK);
	}
	
	@PutMapping("/updateaccount/{id}/{accountId}")
	public ResponseEntity<Object>  doEditAccount(@PathVariable("accountId") int id, @RequestBody  @Valid AccountDto acountDto,  @PathVariable("id") int current) {
		Account account =null ;
		boolean isUpdated=false;
		MasterUser currentUser=userService.getMasterUserById(current);
			if(passwordManagementServiceImpl.getAccountById(id)!=null){
				isUpdated=true;
			String encryptPassword = encryptDecryptPassword.encrypt(acountDto.getPassword());
			account=passwordManagementServiceImpl.getAccountById(id);
			account = new Account(id,acountDto.getUrl(),acountDto.getUsername(),encryptPassword,acountDto.getGroup());
			account=passwordManagementServiceImpl.updateAccount(account,currentUser);
			}
		
		return  new ResponseEntity<>(isUpdated?account:"No Records found", HttpStatus.OK);
	}
	
	
	
	

}
