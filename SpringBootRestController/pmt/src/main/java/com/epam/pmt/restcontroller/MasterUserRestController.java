package com.epam.pmt.restcontroller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.pmt.dto.MasterUserDto;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.servicelayer.PasswordManagementServiceImpl;
import com.epam.pmt.servicelayer.UserServiceImpl;

@RestController
@RequestMapping("/pmt")
public class MasterUserRestController {
	@Autowired
	PasswordManagementServiceImpl passwordManagementServiceImpl;
	MasterUser currentUser;
	HttpHeaders headers=new HttpHeaders();
	@Autowired
	UserServiceImpl userService;
	@PostMapping("/")
	public ResponseEntity<Object> registration(@RequestBody @Valid MasterUserDto masterUserDto) 
	{
			
		 MasterUser  masterUsersave =  userService.addUser(new MasterUser(masterUserDto.getUserid(),masterUserDto.getUsername(),masterUserDto.getPassword()));
		return new ResponseEntity<> (masterUsersave!=null?masterUsersave:"Invalid Master User Details",HttpStatus.OK);
	}

	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> doLogin(@RequestBody MasterUserDto masterUserDto) {
		boolean isValid=false;
		
		if(userService.validateLoginDetails(masterUserDto.getUsername(), masterUserDto.getPassword())) {
			isValid=userService.validateLoginDetails(masterUserDto.getUsername(), masterUserDto.getPassword());
			
		}
		return new ResponseEntity<>(isValid?" Login Successfully":"Invalid Login credentails", HttpStatus.OK );
	}
	
	@GetMapping("/users")
	public  ResponseEntity<List<MasterUser>> viewAllMasterUsers() 
	{
		return new ResponseEntity<>(userService.viewAllUsers(),HttpStatus.OK);
	}
	
	
	
	
}
