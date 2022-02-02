package com.epam.pmt.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstantsUtils {
	private ConstantsUtils() {
		super();
	}

	public static final Logger logger = LogManager.getLogger(ConstantsUtils.class);
	public static final  String GROUP="group";
	public static final  String URLMESSAGE="Oops! Entered URL is Invalid";
	
	public static final String ACTION_1 = "accounts";

	public static final String DELETE_GROUP = "deletegroup";
	public static final String MESSAGE = "message";
	public static final String MODIFY_GROUP = "modifygroup";
	public static final String MODIFY_URL = "modifyurl";
	public static final String SORT_BY_GROUP = "sortbygroup";
	public static final String VIEW_DETAILS = "viewAccount";
	public static final String REDIRECT_VIEW = "redirect:/viewAccount";
	public static final String REDIRECT_WELCOME = "redirect:/welcome";
	public static final String LOGIN = "Please Login First";
	public static final String WELCOME = "welcome";
}
