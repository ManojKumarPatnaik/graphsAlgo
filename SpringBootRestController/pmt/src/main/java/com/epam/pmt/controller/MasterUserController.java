package com.epam.pmt.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.pmt.dto.MasterUserDto;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.InvalidLoginDetail;
import com.epam.pmt.exceptions.InvalidUserName;
import com.epam.pmt.exceptions.MasterUserAlreadyExistsException;
import com.epam.pmt.exceptions.PasswordMismatchException;
import com.epam.pmt.servicelayer.PasswordManagementServiceImpl;
import com.epam.pmt.servicelayer.UserServiceImpl;
import com.epam.pmt.utils.ConstantsUtils;
import com.epam.pmt.utils.CurrentAccount;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;

@Controller
public class MasterUserController {

	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;
	MasterUser currentUser;
	@Autowired
	PasswordManagementServiceImpl crudServiceImpl;
	@Autowired
	UserServiceImpl userService;

	@GetMapping("/masterUserRegister")
	public String registration(@ModelAttribute("masterUser") MasterUserDto masterUserDto) {

		return "register";
	}

	@PostMapping("/masterUserRegister")
	public ModelAndView doRegistration(@ModelAttribute("masterUser")  MasterUserDto masterUserDto) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if(validateUserName.isValidUserName(masterUserDto.getUsername())&&validationPassword.validPassword(masterUserDto.getPassword())) {
			MasterUser masterUser2=new MasterUser(masterUserDto.getUserid(),masterUserDto.getUsername(),masterUserDto.getPassword());
			userService.addUser(masterUser2);
			modelAndView.setViewName(ConstantsUtils.WELCOME);
			modelAndView.addObject(ConstantsUtils.MESSAGE, "Registered Successfully! Login Now");
		}
		} catch (InvalidUserName | PasswordMismatchException|MasterUserAlreadyExistsException message) {
			modelAndView.addObject(ConstantsUtils.MESSAGE, message.getMessage());
			modelAndView.setViewName("register");
		}
		return modelAndView;
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("masterUser") MasterUserDto masterUserDto) {

		return "login";
	}

	@PostMapping("/login")
	public ModelAndView doLogin(@ModelAttribute("masterUser") MasterUserDto masterUserDto) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			userService.validateLoginDetails(masterUserDto.getUsername(), masterUserDto.getPassword());
			currentUser = userService.viewAllUsers().stream()
					.filter(account -> account.getUsername().equals(masterUserDto.getUsername())
							&& account.getPassword().equals(masterUserDto.getPassword()))
					.collect(Collectors.toList()).get(0);
			CurrentAccount.getInstance().setCurrentUser(currentUser);
			modelAndView.setViewName("viewAccount");
			modelAndView.addObject(ConstantsUtils.ACTION_1, crudServiceImpl.viewAllAccounts(CurrentAccount.getInstance().getCurrentUser()));
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
			
			List<MasterUser> masterUsers= userService.viewAllUsers();
			modelAndView.setViewName("viewAllUsers");
			modelAndView.addObject(ConstantsUtils.ACTION_1, masterUsers);

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
