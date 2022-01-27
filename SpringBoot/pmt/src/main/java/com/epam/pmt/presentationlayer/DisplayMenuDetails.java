package com.epam.pmt.presentationlayer;

import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.database.CrudOperationsDbImpl;
import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.PasswordMismatchException;
import com.epam.pmt.exceptions.WrongPasswordException;
import com.epam.pmt.servicelayer.CrudServiceImpl;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;
@Component
public class DisplayMenuDetails {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(DisplayMenuDetails.class);
	private static final Scanner scanner = new Scanner(System.in);
	
	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;
	@Autowired
	CrudOperationsDbImpl crud;
	@Autowired
	CreateAccount create;
	@Autowired
	CrudServiceImpl crudServiceImpl;
	@Autowired
	EntityManagerFactory entityManagerFactory ;
	MasterUser currentUser;
	
	
	public  void ui() throws NullPointerException, PasswordMismatchException {
		
		
		int option=0;
		try {
			MasterUser masterUser= new MasterUser();
			while (true) {
				logger.info("Enter number for Respective Operation");
				logger.info("1.Register as master User");
				logger.info("2.Login as Master User into Password Management system");
				logger.info("3.To exit Application");
				try{
					 option = scanner.nextInt();
				}catch(Exception e) {
					scanner.next();
					ui();
					
				}
				
				switch (option) {
				case 1:
					String username1;

					do {
						System.out.println("Enter Master User Name ");
						username1 = scanner.next();
					} while (!validateUserName.isValidUserName(username1));

					masterUser.setUsername(username1);

					logger.info("Enter MasterPassword ");
					logger.info("note  : password must be encountered with 1 upper case ");
					logger.info("note  : password must be encountered with 1 lower case ");
					logger.info("note  : password must be encountered with 1 numeric ");

					String password = scanner.next();

					if (validationPassword.validPassword(password) == true) {
						logger.debug("Validating Password Criteria : Access Granted.");
						masterUser.setPassword(password);
						logger.debug("Registered successfully");
					}
					EntityManager emanager=entityManagerFactory.createEntityManager();
					emanager.getTransaction().begin();
					emanager.persist(masterUser);
					emanager.getTransaction().commit();
					emanager.close();
					break;

				case 2:
					logger.info("Enter Master User Name  ");
					String username2 = scanner.next();
					logger.info("Enter MasterPassword ");

					String password2 = scanner.next();
					logger.info("User Name " + username2 + " Password");
					

//					if (username2.equals(master.getUsername())) {
//						if (password2.equals(master.getPassword())) {
					if(validateUserName.isValidUserName(username2)==true) {
						if(validationPassword.validPassword(password2) == true) {
							
							currentUser=crud.getAllUsers().stream().filter(account->account.getUsername().equals(username2)&&account.getPassword().equals(password2))
							.collect(Collectors.toList()).get(0);
								CurrentAccount.getInstance().setCurrentUser(currentUser);	
							logger.info("Logined successfully");

							try {
								int option2 = 0;
								do {

									logger.info("Enter number for Respective option");
									logger.info("1.Create Password for an account");
									logger.info("2.Read Password");
									logger.info("3.List Password account and Groups");
									logger.info("4.Delete Password account");
									logger.info("5.Modify/Update password account");
									logger.info("6.Modify Group details");
									logger.info("7.Delete Group");
									logger.info("8.Logout");
									try {
									option2 = scanner.nextInt();
									}catch(Exception e) {
										scanner.next();
										ui();
									}
									if ((option2 < 8)) {
										switch (option2) {
										case 1:
											create.accountService(currentUser);
											
											break;
										case 2:
											System.out.println("Enter account url");
											String accountUrl = scanner.next();
											System.out.println("Enter user name");
											String accountUsername = scanner.next();
											crudServiceImpl.getPassword(accountUrl, accountUsername);
											break;
										case 3:
											System.out.println("Enter group:");
											String group = scanner.next();
											crudServiceImpl.getAccountByGroupName(group);
											break;
										case 4:
											System.out.println("Enter Account Url to delete password account");
											String url = scanner.next();
											crudServiceImpl.deleteAccountByUrl( url);
											break;
										case 5:
											int option5;
											do {
												System.out.println("Choose option");
												System.out.println("1.Update Password");
												System.out.println("2.Update AccountURL");
												System.out.println("3.<-Back");
												option5 = scanner.nextInt();
												if (option5 == 1) {
													System.out.println("Enter url");
													String url1 = scanner.next();
													System.out.println("Enter the new Password");
													String newpassword = scanner.next();
													crudServiceImpl.modifyPassword( url1, newpassword);
												} else if (option5 == 2) {
													System.out.println("Enter url");
													String url1 = scanner.next();
													System.out.println("Enter new url");
													String newUrl1 = scanner.next();
													crudServiceImpl.modifyUrl( url1, newUrl1);
												} else {
													break;
												}
											} while (option5 != 3);
											break;
										case 6:
											System.out.println("Enter old group name ");
											String group1 = scanner.next();
											System.out.println("Enter new group name ");
											String newGroup = scanner.next();
											crudServiceImpl.modifyGroupDetails( group1, newGroup);
											break;
										case 7:
											System.out.println("Enter old group name ");
											String groupName = scanner.next();
											crudServiceImpl.deleteAccountByGroup( groupName);
											break;

										}
									}

								} while (!(option2 == 8));
							} catch (Exception message) {
								logger.warn("Invalid option.");
							}

						} else {
							logger.warn("Invalid Password");
							throw new WrongPasswordException("Oops! Password does not matched!!");
						}
					} else {
						logger.warn("Invalid username");
						throw new  AccountDoesNotExistException("Oops! No Account Found!!");
					}
//				case 3:
//					break;
				}

				if (option == 3) {
					logger.warn("Thank you for using Password Management Tool. Have a Great day!!!\n ");
					
				System.out.println("Exited Successfully from application");
					break;
				}

			}
		}

		catch (Exception message) {
			logger.warn("Thank you for using Password Management Tool. Have a Great day!!!\n ");
			System.out.println("Exited Successfully from application");
		}
	}

}
