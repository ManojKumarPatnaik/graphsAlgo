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

import com.epam.pmt.encryptdecryptpassword.EncryptDecryptPassword;
import com.epam.pmt.encryptdecryptpassword.EncryptionAndDecryption;
import com.epam.pmt.entity.Account;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidUrlException;
import com.epam.pmt.exceptions.LoginFirstException;
import com.epam.pmt.exceptions.NoGroupFoundForAccount;
import com.epam.pmt.exceptions.NoRecordFoundForGroup;
import com.epam.pmt.presentationlayer.CurrentAccount;
import com.epam.pmt.servicelayer.CrudOperationsServiceImpl;
import com.epam.pmt.utils.ConstantsUtils;
import com.epam.pmt.validation.AccountValidation;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;

@Controller
public class AccountController {
	@Autowired
	CrudOperationsServiceImpl crudServiceImpl;
	@Autowired
	AccountValidation validation;
	@Autowired
	EncryptionAndDecryption encryptionAndDecryption;
	@Autowired
	EncryptDecryptPassword encryptDecryptPassword;
	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;


	@GetMapping("/createAccount")
	public ModelAndView createAccount(@ModelAttribute("account") Account account) {
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
	public ModelAndView doCreateAccount(@ModelAttribute("account") Account account) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			validation.isValidURL(account.getUrl());
			validation.isValidGroupName(account.getGroup());
			validateUserName.isValidUserName(account.getUsername());
			validationPassword.validPassword(account.getPassword());
			String encrypt = encryptDecryptPassword.encrypt(account.getPassword());
			account = new Account(account.getUrl(), account.getUsername(), encrypt, account.getGroup());
			crudServiceImpl.addAccount(account);
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
			modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllAccounts());

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
				modelAndView.setViewName(ConstantsUtils.DELETE_GROUP);
				modelAndView.addObject(ConstantsUtils.MESSAGE, "Choose the Group Name want to delete");

				modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllAccounts());
				if (!modelAndView.isEmpty() && crudServiceImpl.deleteAccountByGroup(group)) {
					modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllAccounts());
					modelAndView.addObject("errorMessage", "Account group deleted Successfully");
					modelAndView.setViewName(ConstantsUtils.REDIRECT_VIEW);
				}
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
				modelAndView.addObject(ConstantsUtils.MESSAGE, "Choose the Group Name want to delete");

				modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllAccounts());
				if (!modelAndView.isEmpty() && crudServiceImpl.deleteAccountByUrl(url)) {
					modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllAccounts());
					modelAndView.addObject(ConstantsUtils.MESSAGE, "Account deleted Successfully");
					modelAndView.setViewName(ConstantsUtils.VIEW_DETAILS);
				}
				modelAndView.setViewName(ConstantsUtils.VIEW_DETAILS);
			}
		} catch (InvalidUrlException | AccountDoesNotExistException message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, "no Group Name want to delete");
			modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllAccounts());
			modelAndView.setViewName(ConstantsUtils.VIEW_DETAILS);
		}

		return modelAndView;
	}


	@RequestMapping("/read")
	public ModelAndView readPasswrd(@ModelAttribute("account") Account account ) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (CurrentAccount.getInstance().getCurrentUser() == null) {
				modelAndView.setViewName(ConstantsUtils.REDIRECT_WELCOME);
				modelAndView.addObject(ConstantsUtils.MESSAGE, ConstantsUtils.LOGIN);
			} else {
				modelAndView.setViewName("read");
				String password = crudServiceImpl.getPassword( account.getUsername());
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
			List<Account> newlist = crudServiceImpl.getAccountByGroupName(group);
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
			modelAndView.addObject("account", crudServiceImpl.getAccountById(id));
		}
		return modelAndView;
	}

	@PostMapping("/edit/{id}")
	public ModelAndView doEditAccount(@PathVariable int id, @ModelAttribute("account") Account account) {
		ModelAndView modelAndView = new ModelAndView();
		try {

			validation.isValidURL(account.getUrl());
			validation.isValidGroupName(account.getGroup());
			validateUserName.isValidUserName(account.getUsername());
			validationPassword.validPassword(account.getPassword());
			String encryptPassword = encryptDecryptPassword.encrypt(account.getPassword());
			account.setGroup(account.getGroup());
			account.setPassword(encryptPassword);
			account.setUrl(account.getUrl());
			account.setUsername(account.getUsername());
			crudServiceImpl.updateAccount(account);
			modelAndView.setViewName(ConstantsUtils.REDIRECT_VIEW);
			modelAndView.addObject(ConstantsUtils.MESSAGE, "Account Updated Successfully!");
		} catch (Exception message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName("edit");
		}
		return modelAndView;
	}

}
