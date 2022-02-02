package com.epam.pmt.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidLoginDetail;
import com.epam.pmt.exceptions.InvalidUserName;
import com.epam.pmt.exceptions.PasswordMismatchException;
import com.epam.pmt.presentationlayer.CurrentAccount;
import com.epam.pmt.presentationlayer.Login;
import com.epam.pmt.presentationlayer.MasterAccount;
import com.epam.pmt.servicelayer.CrudOperationsServiceImpl;
import com.epam.pmt.utils.ConstantsUtils;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;

@Controller
public class MasterUserController {

	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;
	@Autowired
	MasterAccount masterAccount;
	@Autowired
	Login login;
	MasterUser currentUser;
	@Autowired
	CrudOperationsServiceImpl crudServiceImpl;

	@GetMapping("/masterUserRegister")
	public String registration(@ModelAttribute("masterUser") MasterUser masterUser) {

		return "register";
	}

	@PostMapping("/masterUserRegister")
	public ModelAndView doRegistration(@ModelAttribute("masterUser") MasterUser masterUser) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if(validateUserName.isValidUserName(masterUser.getUsername())&&validationPassword.validPassword(masterUser.getPassword())) {
			masterAccount.addMasterUser(masterUser.getUsername(), masterUser.getPassword());
			modelAndView.setViewName(ConstantsUtils.WELCOME);
			modelAndView.addObject(ConstantsUtils.MESSAGE, "Registered Successfully! Login Now");
		}} catch (InvalidUserName | PasswordMismatchException message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName("register");
		}
		return modelAndView;
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("masterUser") MasterUser masterUser) {

		return "login";
	}

	@PostMapping("/login")
	public ModelAndView doLogin(@ModelAttribute("masterUser") MasterUser masterUser) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			login.validateLoginDetails(masterUser.getUsername(), masterUser.getPassword());
			currentUser = crudServiceImpl.viewAllUsers().stream()
					.filter(account -> account.getUsername().equals(masterUser.getUsername())
							&& account.getPassword().equals(masterUser.getPassword()))
					.collect(Collectors.toList()).get(0);
			CurrentAccount.getInstance().setCurrentUser(currentUser);
			modelAndView.setViewName("viewAccount");
			modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllAccounts());
			modelAndView.addObject(ConstantsUtils.MESSAGE, "Login Successfully!");
		} catch (InvalidLoginDetail message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@GetMapping("/logout")
	public ModelAndView logOut() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(ConstantsUtils.WELCOME);
		CurrentAccount.getInstance().setCurrentUser(null);
		modelAndView.addObject(ConstantsUtils.MESSAGE, "LogOut Successfully!");
		return modelAndView;
	}

	@GetMapping("/viewAllUsers")
	public ModelAndView viewAllUsers() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("viewAllUsers");
			modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllUsers());

			modelAndView.addObject(ConstantsUtils.MESSAGE, "Displaying All Master Users");
		} catch (AccountDoesNotExistException message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName("viewAllUsers");
		}
		return modelAndView;
	}

	@GetMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ConstantsUtils.MESSAGE, "Please Login First !");
		modelAndView.setViewName(ConstantsUtils.WELCOME);
		return modelAndView;
	}
}
