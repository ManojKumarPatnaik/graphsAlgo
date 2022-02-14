package com.epam.pmt.presentationlayer;

import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epam.pmt.entity.MasterUser;
import com.epam.pmt.exceptions.AccountDoesNotExistException;
import com.epam.pmt.exceptions.PasswordMismatchException;
import com.epam.pmt.exceptions.WrongPasswordException;
import com.epam.pmt.mainapp.Main;
import com.epam.pmt.persistencemanager.CrudOperations;
import com.epam.pmt.servicelayer.DeleteAccountByGroupName;
import com.epam.pmt.servicelayer.DeleteAccountByUrl;
import com.epam.pmt.servicelayer.ListPasswordAccountAndGroup;
import com.epam.pmt.servicelayer.ModifyGroupDetails;
import com.epam.pmt.servicelayer.ModifyPassword;
import com.epam.pmt.servicelayer.ModifyUrl;
import com.epam.pmt.servicelayer.ReadPassword;
import com.epam.pmt.validation.ValidateUserName;
import com.epam.pmt.validation.ValidationPassword;
@Component
public class DisplayMenuDetails {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Main.class);
	private static final Scanner scanner = new Scanner(System.in);
	public static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-mysql-unit");
	public static EntityManager emanager=emFactory.createEntityManager();
	@Autowired
	ValidateUserName validateUserName;
	@Autowired
	ValidationPassword validationPassword;
	@Autowired
	CrudOperations crud;
	@Autowired
	CreateAccount create;
	@Autowired
	ReadPassword readPassword;
	@Autowired
	ListPasswordAccountAndGroup listPasswordAccountAndGroup;
	@Autowired
	DeleteAccountByUrl deleteAccountByUrl;
	@Autowired
	ModifyPassword modifyPassword;
	@Autowired
	ModifyUrl modifyUrl;
	@Autowired
	ModifyGroupDetails modifyGroupDetails;
	@Autowired
	DeleteAccountByGroupName deleteAccountByGroupName;
	
	public  void ui() throws NullPointerException, PasswordMismatchException {
		@SuppressWarnings("resource")
		ApplicationContext context=new AnnotationConfigApplicationContext(Main.class);
		
		try {
			MasterUser masterUser= context.getBean(MasterUser.class);
			while (true) {
				logger.info("Enter number for Respective Operation");
				logger.info("1.Register as master User");
				logger.info("2.Login as Master User into Password Management system");
				logger.info("3.To exit Application");
				int option = scanner.nextInt();
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
					emanager.getTransaction().begin();
					emanager.persist(masterUser);
					emanager.getTransaction().commit();
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
							crud.getAllUsers().stream().filter(account->account.getUsername().equals(username2)&&account.getPassword().equals(password2))
							.collect(Collectors.toList()).get(0);
							logger.info("Logined successfully");
							int option2;

							try {
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

									option2 = scanner.nextInt();
									if ((option2 < 8)) {
										switch (option2) {
										case 1:
											create.accountService();
											
											break;
										case 2:
											System.out.println("Enter account url");
											String accountUrl = scanner.next();
											System.out.println("Enter user name");
											String accountUsername = scanner.next();
											readPassword.getPassword( accountUrl, accountUsername);
											break;
										case 3:
											System.out.println("Enter group:");
											String group = scanner.next();
											listPasswordAccountAndGroup.getAccountByGroupName(group);
											break;
										case 4:
											System.out.println("Enter Account Url to delete password account");
											String url = scanner.next();
											deleteAccountByUrl.deleteAccountByUrl( url);
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
													modifyPassword.modifyPassword( url1, newpassword);
												} else if (option5 == 2) {
													System.out.println("Enter url");
													String url1 = scanner.next();
													System.out.println("Enter new url");
													String newUrl1 = scanner.next();
													modifyUrl.modifyUrl( url1, newUrl1);
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
											modifyGroupDetails.modifyGroupDetails( group1, newGroup);
											break;
										case 7:
											System.out.println("Enter old group name ");
											String groupName = scanner.next();
											deleteAccountByGroupName.deleteAccountByGroup( groupName);
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
					
					break;
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
