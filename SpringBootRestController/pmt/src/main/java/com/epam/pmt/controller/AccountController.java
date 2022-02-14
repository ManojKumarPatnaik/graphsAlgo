package com.epam.pmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.pmt.dto.AccountDto;
import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.LoginFirstException;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;
import com.epam.pmt.servicelayer.PasswordManagementServiceImpl;
import com.epam.pmt.utils.ConstantsUtils;
import com.epam.pmt.utils.CurrentAccount;
import com.epam.pmt.validation.AccountValidation;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;

@Controller
public class AccountController {
	@Autowired
	PasswordManagementServiceImpl passwordManagementServiceImpl;
	@Autowired
	AccountValidation accountValidation;
	@Autowired
	EncryptionAndDecryption encryptionAndDecryption;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;


	@GetMapping("/createAccount")
	public ModelAndView createAccount(@ModelAttribute("account") AccountDto acountDto) {
		ModelAndView modelAndView = new ModelAndView();
		if (CurrentAccount.getInstance().getCurrentUser() == null) {
			modelAndView.setViewName(ConstantsUtils.REDIRECT_WELCOME);
			modelAndView.addObject(ConstantsUtils.MESSAGE, ConstantsUtils.LOGIN);
		} else {
			modelAndView.setViewName("createAccount");
		}
		return modelAndView;
	}
	

	@PostMapping("/createAccount")
	public ModelAndView doCreateAccount(@ModelAttribute("account")  AccountDto acountDto) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			accountValidation.isValidURL(acountDto.getUrl());
			accountValidation.isValidGroupName(acountDto.getGroup());
			validateUserName.isValidUserName(acountDto.getUsername());
			validationPassword.validPassword(acountDto.getPassword());
			String encrypt = encryptDecryptPassword.encrypt(acountDto.getPassword());
			Account account1 = new Account(acountDto.getUrl(), acountDto.getUsername(), encrypt, acountDto.getGroup());
			passwordManagementServiceImpl.addAccount(account1,CurrentAccount.getInstance().getCurrentUser());
			modelAndView.setViewName(ConstantsUtils.REDIRECT_VIEW);
			modelAndView.addObject(ConstantsUtils.MESSAGE, "Account Created Successfully!");
		} catch (Exception  message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName("createAccount");
		}
		return modelAndView;
	}

	@GetMapping("/viewAccount")
	public ModelAndView viewAccount() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (CurrentAccount.getInstance().getCurrentUser() == null) {
				throw new LoginFirstException(ConstantsUtils.LOGIN);
			}
			modelAndView.setViewName(ConstantsUtils.VIEW_DETAILS);
			modelAndView.addObject(ConstantsUtils.ACTION_1, passwordManagementServiceImpl.viewAllAccounts(CurrentAccount.getInstance().getCurrentUser()));

			modelAndView.addObject(ConstantsUtils.MESSAGE, "Displaying All Accounts");
		} catch (AccountDoesNotExistException | LoginFirstException message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName(ConstantsUtils.WELCOME);
		}
		return modelAndView;
	}

	@GetMapping("/menu")
	public ModelAndView menu() {
		ModelAndView modelAndView = new ModelAndView();
		if (CurrentAccount.getInstance().getCurrentUser() == null) {
			modelAndView.setViewName(ConstantsUtils.REDIRECT_WELCOME);
			modelAndView.addObject(ConstantsUtils.MESSAGE, ConstantsUtils.LOGIN);
		} else {
			modelAndView.setViewName("menu");
		}
		return modelAndView;
	}

	
	
	@RequestMapping("deletegroup")
	public ModelAndView deletegroup(String group) {
		ModelAndView modelAndView = new ModelAndView();

		try {
			if (CurrentAccount.getInstance().getCurrentUser() == null) {
				modelAndView.setViewName(ConstantsUtils.REDIRECT_WELCOME);
				modelAndView.addObject(ConstantsUtils.MESSAGE, ConstantsUtils.LOGIN);
			} else {
				modelAndView.addObject(ConstantsUtils.ACTION_1, passwordManagementServiceImpl.viewAllAccounts(CurrentAccount.getInstance().getCurrentUser()));
				passwordManagementServiceImpl.deleteAccountByGroup(group,CurrentAccount.getInstance().getCurrentUser());
					modelAndView.addObject(ConstantsUtils.ACTION_1, passwordManagementServiceImpl.viewAllAccounts(CurrentAccount.getInstance().getCurrentUser()));
					modelAndView.addObject(ConstantsUtils.MESSAGE, "Account group deleted Successfully");
					modelAndView.setViewName(ConstantsUtils.REDIRECT_VIEW);
			}
		} catch (NoRecordFoundForGroup | AccountDoesNotExistException message) {
			modelAndView.setViewName(ConstantsUtils.DELETE_GROUP);
		}

		return modelAndView;
	}

	@RequestMapping("/deleteUrl")
	public ModelAndView deleteByUrl(String url) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (CurrentAccount.getInstance().getCurrentUser() == null) {
				modelAndView.setViewName(ConstantsUtils.REDIRECT_WELCOME);
				modelAndView.addObject(ConstantsUtils.MESSAGE, ConstantsUtils.LOGIN);
			} else {
				modelAndView.setViewName(ConstantsUtils.VIEW_DETAILS);
				modelAndView.addObject(ConstantsUtils.MESSAGE, "Choose the account want to delete");
				passwordManagementServiceImpl.deleteAccountByUrl(url,CurrentAccount.getInstance().getCurrentUser());
				modelAndView.addObject(ConstantsUtils.ACTION_1,  passwordManagementServiceImpl.viewAllAccounts(CurrentAccount.getInstance().getCurrentUser()));
				modelAndView.addObject(ConstantsUtils.MESSAGE, "Account deleted Successfully");
			}
		} catch (InvalidUrlException | AccountDoesNotExistException message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, "no account want to delete");
			modelAndView.addObject(ConstantsUtils.ACTION_1, passwordManagementServiceImpl.viewAllAccounts(CurrentAccount.getInstance().getCurrentUser()));
			modelAndView.setViewName(ConstantsUtils.VIEW_DETAILS);
		}

		return modelAndView;
	}

	

	@RequestMapping("/read")
	public ModelAndView readPasswrd(@ModelAttribute("account") AccountDto acountDto ) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (CurrentAccount.getInstance().getCurrentUser() == null) {
				modelAndView.setViewName(ConstantsUtils.REDIRECT_WELCOME);
				modelAndView.addObject(ConstantsUtils.MESSAGE, ConstantsUtils.LOGIN);
			} else {
				modelAndView.setViewName("read");
				String password = passwordManagementServiceImpl.getPassword( acountDto.getUsername(),CurrentAccount.getInstance().getCurrentUser());
				if (!password.isEmpty()) {
					modelAndView.addObject(ConstantsUtils.MESSAGE, "The Decrypted password : " + password);
				}
			}
		} catch ( Exception message) {
			modelAndView.setViewName("read");
		}
		return modelAndView;

	}

	

	

	@GetMapping("/sortbygroup")
	public ModelAndView sortbygroup(String group) {
		ModelAndView modelAndView = new ModelAndView();
		if (CurrentAccount.getInstance().getCurrentUser() == null) {
			modelAndView.setViewName(ConstantsUtils.REDIRECT_WELCOME);
			modelAndView.addObject(ConstantsUtils.MESSAGE, ConstantsUtils.LOGIN);
		} else {
			modelAndView.setViewName(ConstantsUtils.SORT_BY_GROUP);
		}
		return modelAndView;

	}

	@PostMapping("/sortbygroup")
	public ModelAndView dosortbygroup(String group) {
		ModelAndView modelAndView = new ModelAndView();
		try {

			modelAndView.setViewName(ConstantsUtils.SORT_BY_GROUP);
			List<Account> newlist = passwordManagementServiceImpl.getAccountByGroupName(group,CurrentAccount.getInstance().getCurrentUser());
			if (!newlist.isEmpty()) {
				modelAndView.addObject(ConstantsUtils.MESSAGE, "Results found on bases of group name.");
				modelAndView.addObject(ConstantsUtils.ACTION_1, newlist);
				modelAndView.setViewName(ConstantsUtils.VIEW_DETAILS);
			}

		} catch (NoGroupFoundForAccount message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName(ConstantsUtils.SORT_BY_GROUP);
		}

		return modelAndView;

	}

	@GetMapping("/edit/{id}")
	public ModelAndView editAccount(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("edit");
		if (CurrentAccount.getInstance().getCurrentUser() == null) {
			modelAndView.setViewName(ConstantsUtils.REDIRECT_WELCOME);
			modelAndView.addObject(ConstantsUtils.MESSAGE, ConstantsUtils.LOGIN);
		} else {
			modelAndView.setViewName("edit");
			modelAndView.addObject("account", passwordManagementServiceImpl.getAccountById(id));
		}
		return modelAndView;
	}

	@PostMapping("/edit/{id}")
	public ModelAndView doEditAccount(@PathVariable int id, @ModelAttribute("account")  AccountDto acountDto) {
		ModelAndView modelAndView = new ModelAndView();
		try {

			accountValidation.isValidURL(acountDto.getUrl());
			accountValidation.isValidGroupName(acountDto.getGroup());
			validateUserName.isValidUserName(acountDto.getUsername());
			validationPassword.validPassword(acountDto.getPassword());
			String encryptPassword = encryptDecryptPassword.encrypt(acountDto.getPassword());
			Account account=new Account();
			account.setAccountId(id);
			account.setGroup(acountDto.getGroup());
			account.setPassword(encryptPassword);
			account.setUrl(acountDto.getUrl());
			account.setUsername(acountDto.getUsername());
			passwordManagementServiceImpl.updateAccount(account,CurrentAccount.getInstance().getCurrentUser());
			modelAndView.setViewName(ConstantsUtils.REDIRECT_VIEW);
			modelAndView.addObject(ConstantsUtils.MESSAGE, "Account Updated Successfully!");
		} catch (Exception message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName("edit");
		}
		return modelAndView;
	}

}
